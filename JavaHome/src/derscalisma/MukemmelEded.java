package derscalisma;

import java.util.Scanner;

public class MukemmelEded {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tam ədəd daxil edin: ");
        int eded = scanner.nextInt();

        if (eded > 0) {
            if (mukemmelEdedMi(eded)) {
                System.out.println(eded + " mükəmməl ədəddir.");
            } else {
                System.out.println(eded + " mükəmməl ədəd deyil.");
            }
        } else {
            System.out.println("Zəhmət olmasa müsbət tam ədəd daxil edin.");
        }

        scanner.close();
    }

    public static boolean mukemmelEdedMi(int n) {
        int cem = 0;

        // 1-dən n-1-ə kimi bütün ədədləri yoxlayırıq
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                cem += i;
            }
        }

        return cem == n;
    }
}
