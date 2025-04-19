package az.devolopia.librarian_mubariz_bayramov.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.entity.LibrarianBookCountEntity;

public interface LibrarianBookCountRepo extends JpaRepository<LibrarianBookCountEntity, Integer> {

}
