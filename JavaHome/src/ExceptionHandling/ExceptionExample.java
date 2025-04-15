package ExceptionHandling;
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Burada ArithmeticException yaranır
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Xəta: Sıfıra bölmək olmaz!");
        }
    }
}
