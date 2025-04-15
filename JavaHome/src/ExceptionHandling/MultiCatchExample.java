package ExceptionHandling;
public class MultiCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            int result = 10 / 0; // ArithmeticException
            System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }

        System.out.println("Proqram davam edir...");
    }
}
