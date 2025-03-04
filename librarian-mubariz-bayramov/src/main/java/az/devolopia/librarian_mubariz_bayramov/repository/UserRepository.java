package az.devolopia.librarian_mubariz_bayramov.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}