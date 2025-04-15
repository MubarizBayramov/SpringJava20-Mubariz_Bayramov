package ExceptionHandling;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        try {
            System.out.println("Əsas try bloku başladı...");

            try {
                int result = 10 / 0; // ArithmeticException
                System.out.println("Nəticə: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Daxili catch: Sıfıra bölmək olmaz!");
            }

            try {
                int[] numbers = {1, 2, 3};
                System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Daxili catch: Dizin hüdudlarından kənara çıxma!");
            }

            System.out.println("Əsas try bloku bitdi.");
        } catch (Exception e) {
            System.out.println("Ümumi catch bloku: Naməlum xəta!");
        }

        System.out.println("Proqram davam edir...");
    }
}
