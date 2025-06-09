package az.devolopia.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.tourist.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    
}
