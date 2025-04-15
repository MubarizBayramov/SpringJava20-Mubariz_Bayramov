package ExceptionHandling;
public class TryCatch {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // Burada xəta (ArithmeticException) yaranır
            System.out.println("Nəticə: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Xəta baş verdi: Sıfıra bölmək mümkün deyil!");
        }
        
        System.out.println("Proqram davam edir...");
    }
}
