package az.devolopia.librarian_mubariz_bayramov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.devolopia.librarian_mubariz_bayramov.util.Authority;
interface AuthorityRepository extends JpaRepository<Authority, Long> {}