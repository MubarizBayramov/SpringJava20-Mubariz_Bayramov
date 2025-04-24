package az.devolopia.librarian_mubariz_bayramov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentBookEntity;

public interface StudentBookRepository extends JpaRepository<StudentBookEntity, Integer> {
}
