package az.devolopia.librarian_mubariz_bayramov.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    boolean existsByEmail(String email);

    List<StudentEntity> findByNameContaining(String name);
    
    List<StudentEntity> findByNameContainingIgnoreCase(String name);

}
