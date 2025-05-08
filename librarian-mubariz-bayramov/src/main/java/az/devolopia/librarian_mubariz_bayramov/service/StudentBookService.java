package az.devolopia.librarian_mubariz_bayramov.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.StudentBookEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.BookRepository;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentBookRepository;
import az.devolopia.librarian_mubariz_bayramov.repository.StudentRepository;
import az.devolopia.librarian_mubariz_bayramov.request.GiveBookRequest;
import az.devolopia.librarian_mubariz_bayramov.request.ReturnBookRequest;
import az.devolopia.librarian_mubariz_bayramov.response.DelayedBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.GiveBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.GivenBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.ReturnBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.StudentBookResponse;
import az.devolopia.librarian_mubariz_bayramov.util.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentBookService {

	
    private final StudentBookRepository studentBookRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public GiveBookResponse giveBookToStudent(@Valid GiveBookRequest request, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }

        StudentEntity student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new MyException("Tələbə tapılmadı!", null, "NotFound"));

        BookEntity book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new MyException("Kitab tapılmadı!", null, "NotFound"));

        if (book.getQuantity() <= 0) {
            throw new MyException("Kitab stokda yoxdur!", null, "OutOfStock");
        }

        if (studentBookRepository.existsByBookIdAndStudentIdAndReturnedFalse(book.getId(), student.getId())) {
            throw new MyException("Bu kitab artıq tələbəyə verilib!", null, "Duplicate");
        }

        StudentBookEntity entity = new StudentBookEntity();
        entity.setStudentId(student.getId());
        entity.setBookId(book.getId());
        entity.setGivenDate(LocalDate.now());
        entity.setDueDate(request.getDueDate());
        entity.setReturned(false);
        studentBookRepository.save(entity);

        // Azalt kitab sayını
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        return new GiveBookResponse("Kitab uğurla verildi", entity.getGivenDate(), entity.getDueDate());
    }
    
    public ReturnBookResponse returnBookFromStudent(@Valid ReturnBookRequest request, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyException(Constants.VALIDATION_MESSAGE, br, Constants.VALIDATION_TYPE);
        }

        StudentBookEntity studentBook = studentBookRepository
                .findAll()
                .stream()
                .filter(s -> s.getBookId().equals(request.getBookId())
                        && s.getStudentId().equals(request.getStudentId())
                        && !s.isReturned())
                .findFirst()
                .orElseThrow(() -> new MyException("Bu tələbəyə aid verilməmiş kitab tapılmadı!", null, "NotFound"));

        studentBook.setReturned(true);
        studentBookRepository.save(studentBook);

        // Kitab sayını artır
        BookEntity book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new MyException("Kitab tapılmadı!", null, "NotFound"));
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        return new ReturnBookResponse("Kitab uğurla qaytarıldı", LocalDate.now());
    }
    
    public List<GivenBookResponse> getAllGivenBooksByLibrarian(Integer librarianCode) {
        List<StudentBookEntity> studentBooks = studentBookRepository.findAll();

        return studentBooks.stream()
                .filter(sb -> {
                    StudentEntity student = studentRepository.findById(sb.getStudentId()).orElse(null);
                    BookEntity book = bookRepository.findById(sb.getBookId()).orElse(null);
                    return student != null && book != null && student.getLibrarianCode().equals(librarianCode);
                })
                .map(sb -> {
                    BookEntity book = bookRepository.findById(sb.getBookId()).orElse(null);
                    StudentEntity student = studentRepository.findById(sb.getStudentId()).orElse(null);

                    return new GivenBookResponse(
                            book != null ? book.getName() : "Unknown Book",
                            student != null ? student.getName() + " " + student.getSurname() : "Unknown Student",
                            sb.getGivenDate(),
                            sb.getDueDate(),
                            sb.isReturned()
                    );
                })
                .collect(Collectors.toList());
    }
    public List<StudentBookResponse> getReturnedBooks(Integer librarianCode) {
        List<StudentBookEntity> list = studentBookRepository.findAllReturnedBooksByLibrarianCode(librarianCode);
        
        return list.stream().map(e -> {
            BookEntity book = bookRepository.findById(e.getBookId()).orElse(null);
            StudentEntity student = studentRepository.findById(e.getStudentId()).orElse(null);

            StudentBookResponse response = new StudentBookResponse();
            response.setBookName(book != null ? book.getName() : "N/A");
            response.setStudentName(student != null ? student.getName() + " " + student.getSurname() : "N/A");
            response.setGivenDate(e.getGivenDate());
            response.setDueDate(e.getDueDate());
            response.setReturned(e.isReturned());
            return response;
        }).toList();
    }
    public List<DelayedBookResponse> getDelayedBooks(Integer librarianCode) {
        LocalDate today = LocalDate.now();
        
        List<StudentBookEntity> list = studentBookRepository.findAllDelayedBooksByLibrarianCodeAndNotReturned(librarianCode, today);
        
        return list.stream().map(e -> {
            BookEntity book = bookRepository.findById(e.getBookId()).orElse(null);
            StudentEntity student = studentRepository.findById(e.getStudentId()).orElse(null);

            DelayedBookResponse response = new DelayedBookResponse();
            response.setBookName(book != null ? book.getName() : "N/A");
            response.setStudentName(student != null ? student.getName() + " " + student.getSurname() : "N/A");
            response.setGivenDate(e.getGivenDate());
            response.setDueDate(e.getDueDate());
            response.setReturned(e.isReturned());
            return response;
        }).toList();
    }
 // Tələbənin götürdüyü kitabları tapır
    public List<StudentBookEntity> getBooksByStudentId(Integer studentId) {
        return studentBookRepository.findByStudentIdAndIsReturnedFalse(studentId);
    }
 

}
