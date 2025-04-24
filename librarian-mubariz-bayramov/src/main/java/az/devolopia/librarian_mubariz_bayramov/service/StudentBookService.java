package az.devolopia.librarian_mubariz_bayramov.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.LibrarianEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.StudentBookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.BookRepository;
import az.devolopia.librarian_mubariz_bayramov.repository.LibrarianRepository;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentBookRepository;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentRepository;
import az.devolopia.librarian_mubariz_bayramov.request.GiveBookRequest;
import az.devolopia.librarian_mubariz_bayramov.response.GiveBookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentBookService {

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final LibrarianRepository librarianRepository;
    private final StudentBookRepository studentBookRepository;

    public GiveBookResponse giveBookToStudent(@Valid GiveBookRequest request, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException("Validation error", br, "VALIDATION");
        }

        StudentEntity student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new MyException("Student not found", null, "NOT_FOUND"));

        BookEntity book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new MyException("Book not found", null, "NOT_FOUND"));

        if (book.getQuantity() <= 0) {
            throw new MyException("Book is not available in stock", null, "OUT_OF_STOCK");
        }

        LibrarianEntity librarian = librarianRepository.findById(request.getLibrarianId())
                .orElseThrow(() -> new MyException("Librarian not found", null, "NOT_FOUND"));

        // Kitabı ver və miqdarı azald
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        LocalDate now = LocalDate.now();
        LocalDate due = now.plusWeeks(2); // 2 həftəlik verilir

        StudentBookEntity studentBook = new StudentBookEntity(null, student.getId(), book.getId(), now, due, librarian.getId());
        studentBookRepository.save(studentBook);

        return new GiveBookResponse("Book successfully given to student", now, due);
    }
}
