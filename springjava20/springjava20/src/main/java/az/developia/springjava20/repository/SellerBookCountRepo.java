package az.developia.springjava20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava20.entity.SellerBookCountEntity;

public interface SellerBookCountRepo extends JpaRepository<SellerBookCountEntity, Integer> {

}