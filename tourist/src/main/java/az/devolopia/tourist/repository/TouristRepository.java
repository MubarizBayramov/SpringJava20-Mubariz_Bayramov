package az.devolopia.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.tourist.entity.TouristEntity;

public interface TouristRepository extends JpaRepository<TouristEntity, Integer> {
    
}
