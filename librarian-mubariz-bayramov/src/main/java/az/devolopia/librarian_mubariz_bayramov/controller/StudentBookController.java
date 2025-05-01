package az.devolopia.librarian_mubariz_bayramov.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.request.GiveBookRequest;
import az.devolopia.librarian_mubariz_bayramov.request.ReturnBookRequest;
import az.devolopia.librarian_mubariz_bayramov.response.GiveBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.GivenBookResponse;
import az.devolopia.librarian_mubariz_bayramov.response.ReturnBookResponse;
import az.devolopia.librarian_mubariz_bayramov.service.StudentBookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student-books")
public class StudentBookController {

    private final StudentBookService studentBookService;

    @PostMapping("/give")
    public ResponseEntity<GiveBookResponse> giveBookToStudent(
            @Valid @RequestBody GiveBookRequest request,
            BindingResult br) {
        GiveBookResponse response = studentBookService.giveBookToStudent(request, br);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/return")
    public ResponseEntity<ReturnBookResponse> returnBookFromStudent(
            @Valid @RequestBody ReturnBookRequest request,
            BindingResult br) {
        ReturnBookResponse response = studentBookService.returnBookFromStudent(request, br);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/given-books/{librarianCode}")
    public ResponseEntity<List<GivenBookResponse>> getGivenBooksByLibrarian(@PathVariable Integer librarianCode) {
        List<GivenBookResponse> responseList = studentBookService.getAllGivenBooksByLibrarian(librarianCode);
        return ResponseEntity.ok(responseList);
    }

}
