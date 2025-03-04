package az.devolopia.librarian_mubariz_bayramov.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.util.Librarian;


public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Optional<Librarian> findByUsername(String username);
}
