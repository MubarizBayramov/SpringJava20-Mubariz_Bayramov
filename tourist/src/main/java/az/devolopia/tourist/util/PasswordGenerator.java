package az.devolopia.tourist.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        System.out.println("l1: " + new BCryptPasswordEncoder().encode("1234"));
        System.out.println("l2: " + new BCryptPasswordEncoder().encode("5678"));
    }
}
