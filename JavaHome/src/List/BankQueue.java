package List;

import java.util.LinkedList;
import java.util.Queue;

public class BankQueue {
    public static void main(String[] args) {
        Queue<String> customerQueue = new LinkedList<>();

        // Müştərilər növbəyə daxil olur
        customerQueue.add("Mübariz");
        customerQueue.add("Rahid");
        customerQueue.add("Ayşə");
        customerQueue.add("Elvin");

        System.out.println("Növbədəki müştərilər: " + customerQueue);

        // Kassir müştərilərə xidmət göstərir
        while (!customerQueue.isEmpty()) {
            String customer = customerQueue.poll(); // poll  - Növbədən çıxar
            System.out.println("Kassir xidmət göstərir: " + customer);
        }

        System.out.println("Növbə boşdur.");
    }
}
