package az.devolopia.librarian_mubariz_bayramov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.devolopia.librarian_mubariz_bayramov.service.LibrarianService;
import az.devolopia.librarian_mubariz_bayramov.util.Librarian;

@RestController
@RequestMapping("/librarians")

public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;
    
    @PostMapping("/create")
    public Librarian createLibrarian(@RequestBody Librarian librarian) {

        return Librarian.createLibrarian(librarian);

    }
}