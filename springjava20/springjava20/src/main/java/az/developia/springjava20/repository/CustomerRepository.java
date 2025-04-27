package az.developia.springjava20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava20.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}