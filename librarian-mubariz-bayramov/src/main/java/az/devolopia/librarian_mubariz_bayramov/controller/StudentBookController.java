package az.devolopia.librarian_mubariz_bayramov.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.request.GiveBookRequest;
import az.devolopia.librarian_mubariz_bayramov.response.GiveBookResponse;
import az.devolopia.librarian_mubariz_bayramov.service.StudentBookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class StudentBookController {

    private final StudentBookService studentBookService;

    @PostMapping("/give-to-student")
    @PreAuthorize("hasAuthority('ROLE_ADD_BOOK')")
    public ResponseEntity<GiveBookResponse> giveBook(
            @RequestBody @Valid GiveBookRequest request,
            BindingResult br
    ) {
        GiveBookResponse response = studentBookService.giveBookToStudent(request, br);
        return ResponseEntity.ok(response);
    }
}

