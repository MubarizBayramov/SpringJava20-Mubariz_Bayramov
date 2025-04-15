package List;
import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Elementləri stack-ə əlavə et
        stack.push("Mübariz");
        stack.push("Rahid");
        stack.push("Ayşə");

        System.out.println("Stack: " + stack); // [Mübariz, Rahid, Ayşə]

        // Elementləri çıxar və göstər (LIFO)
        while (!stack.isEmpty()) {
            String name = stack.pop(); // Son daxil olan birinci çıxır
            System.out.println("Çıxarıldı: " + name);
        }
    }
}
