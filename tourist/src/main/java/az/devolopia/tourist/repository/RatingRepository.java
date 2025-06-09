package az.devolopia.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.tourist.entity.RatingEntity;

public interface RatingRepository extends JpaRepository<RatingEntity, Integer> {
    
}
