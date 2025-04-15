package JavaEsas;

import java.util.Scanner; // Scanner sinifini əlavə edirik

public class scener {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner obyekti yaradılır
        
        // İstifadəçidən ad və yaş daxil etməsini istəyirik
        System.out.print("Adınızı daxil edin: ");
        String name = scanner.nextLine(); // Sətir (String) oxuyur
        
        System.out.print("Yaşınızı daxil edin: ");
        int age = scanner.nextInt(); // Tam ədəd (int) oxuyur
        
        System.out.println("Salam, " + name + "! Sizin yaşınız: " + age);
        
        scanner.close(); // Scanner-i bağlayırıq (tövsiyə olunur)
    }
    
    
}
