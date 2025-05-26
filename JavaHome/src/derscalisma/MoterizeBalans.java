package derscalisma;

import java.util.Stack;

public class MoterizeBalans {
    public static void main(String[] args) {
        String metn = "{[()]}()[]";  // Test üçün nümunə mətn

        if (moterizeBalanslidirMi(metn)) {
            System.out.println("Mötərizələr balanslıdır.");
        } else {
            System.out.println("Mötərizələr balanslı deyil.");
        }
    }

    public static boolean moterizeBalanslidirMi(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // Açılan mötərizələr stəka əlavə edilir
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Bağlanan mötərizələr üçün yoxlama
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Bağlanan mötərizə var, amma açılan yox
                }
                char acilan = stack.pop();
                if (!ciftUyqundur(acilan, ch)) {
                    return false; // Uyğun açılan-bağlanan cüt deyil
                }
            }
        }

        // Əgər stək boşdursa, bütün mötərizələr balanslıdır
        return stack.isEmpty();
    }

    private static boolean ciftUyqundur(char acilan, char baglanan) {
        return (acilan == '(' && baglanan == ')') ||
               (acilan == '{' && baglanan == '}') ||
               (acilan == '[' && baglanan == ']');
    }
}
