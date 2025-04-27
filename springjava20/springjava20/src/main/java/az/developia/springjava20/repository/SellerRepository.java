package az.developia.springjava20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava20.entity.SellerEntity;

public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {

}