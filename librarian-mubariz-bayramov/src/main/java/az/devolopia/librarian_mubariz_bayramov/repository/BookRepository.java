package az.devolopia.librarian_mubariz_bayramov.repository;


import az.devolopia.librarian_mubariz_bayramov.entity.BookEntity;

import java.awt.print.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	Book save(Book book);

}

