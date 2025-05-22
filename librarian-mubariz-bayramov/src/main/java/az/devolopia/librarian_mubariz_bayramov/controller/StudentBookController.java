package az.devolopia.librarian_mubariz_bayramov.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.entity.LibrarianEntity;
import az.devolopia.librarian_mubariz_bayramov.entity.StudentBookEntity;
import az.devolopia.librarian_mubariz_bayramov.exception.MyException;
import az.devolopia.librarian_mubariz_bayramov.repository.LibrarianRepository;
import az.devolopia.librarian_mubariz_bayramov.request.GiveBookRequest;
import az.devolopia.librarian_mubariz_bayramov.request.ReturnBookRequest;
import az.devolopia.librarian_mubariz_bayramov.response.DelayedBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.GiveBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.GivenBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.ReturnBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.StudentBookResponse;
import az.devolopia.librarian_mubariz_bayramov.service.StudentBookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/student-books")
public class StudentBookController {
	@Autowired
	private 
	LibrarianRepository librarianRepository;
	@Autowired
    private StudentBookService studentBookService;
    

	@PreAuthorize("hasAuthority('ROLE_GIVE_BOOK')")
    @PostMapping("/give")
    public ResponseEntity<GiveBookResponse> giveBookToStudent(
            @Valid @RequestBody GiveBookRequest request,
            BindingResult br) {
        GiveBookResponse response = studentBookService.giveBookToStudent(request, br);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('ROLE_RETURN_BOOK')")
    @PostMapping("/return")
    public ResponseEntity<ReturnBookResponse> returnBookFromStudent(
            @Valid @RequestBody ReturnBookRequest request,
            BindingResult br) {
        ReturnBookResponse response = studentBookService.returnBookFromStudent(request, br);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('ROLE_GET_GIVEN_BOOKS')")
    @GetMapping("/given-books/{librarianCode}")
    public ResponseEntity<List<GivenBookResponse>> getGivenBooksByLibrarian(@PathVariable Integer librarianCode) {
        List<GivenBookResponse> responseList = studentBookService.getAllGivenBooksByLibrarian(librarianCode);
        return ResponseEntity.ok(responseList);
    }

    @PreAuthorize("hasAuthority('ROLE_GET_RETURNED_BOOKS')")
    @GetMapping("/returned-books/{librarianCode}")
    public ResponseEntity<List<StudentBookResponse>> getReturnedBooks(
            @PathVariable Integer librarianCode,
            Principal principal) {
        String username = principal.getName();
        LibrarianEntity librarian = librarianRepository.findByName(username);
        if (!librarian.getId().equals(librarianCode)) {
            throw new MyException("Bu əməliyyata icazəniz yoxdur!", null, "Authorization");
        }
        return ResponseEntity.ok(studentBookService.getReturnedBooks(librarianCode));
    }

    @PreAuthorize("hasAuthority('ROLE_GET_DELAYED_BOOKS')")
    @GetMapping("/delayed-books/{librarianCode}")
    public ResponseEntity<List<DelayedBookResponse>> getDelayedBooks(
            @PathVariable Integer librarianCode,
            Principal principal) {
        String username = principal.getName();
        LibrarianEntity librarian = librarianRepository.findByName(username);
        if (!librarian.getId().equals(librarianCode)) {
            throw new MyException("Bu əməliyyata icazəniz yoxdur!", null, "Authorization");
        }
        return ResponseEntity.ok(studentBookService.getDelayedBooks(librarianCode));
    }
    
 // Tələbənin götürdüyü kitabları görmək üçün API
    
    @GetMapping("/{studentId}/books")
    public List<StudentBookEntity> getBooksByStudentId(@PathVariable Integer studentId) {
        return studentBookService.getBooksByStudentId(studentId);
    }
}
