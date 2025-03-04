package az.devolopia.librarian_mubariz_bayramov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.devolopia.librarian_mubariz_bayramov.repository.LibrarianRepository;
import az.devolopia.librarian_mubariz_bayramov.util.Librarian;

@Service
public
 class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;
    

    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Librarian createLibrarian(Librarian librarian) {
    	librarian.setPassword(passwordEncoder.encode(librarian.getPassword()));
    	 return librarianRepository.save(librarian);
    }
}
