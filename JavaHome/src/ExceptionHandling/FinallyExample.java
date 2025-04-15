package ExceptionHandling;

public class FinallyExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Xəta: Dizin hüdudlarından kənara çıxma!");
        } finally {
            System.out.println("Bu mesaj həmişə çap olunacaq.");
        }
    }
}

