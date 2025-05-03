package az.devolopia.librarian_mubariz_bayramov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.entity.LibrarianEntity;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity, Integer> {
    LibrarianEntity findByName(String name);  // Librarianın adına görə axtarış
}
