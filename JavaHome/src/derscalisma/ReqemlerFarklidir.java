package derscalisma;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReqemlerFarklidir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tam ədəd daxil edin: ");
        int eded = scanner.nextInt();

        if (butunReqemlerFarklidir(eded)) {
            System.out.println("Bəli, bütün rəqəmlər fərqlidir.");
        } else {
            System.out.println("Xeyr, bəzi rəqəmlər təkrarlanır.");
        }

        scanner.close();
    }

    public static boolean butunReqemlerFarklidir(int n) {
        n = Math.abs(n);  // Mənfi ədədlər üçün

        Set<Integer> reqemler = new HashSet<>();

        while (n > 0) {
            int reqem = n % 10;
            if (reqemler.contains(reqem)) {
                return false; // Rəqəm təkrarlanır
            }
            reqemler.add(reqem);
            n /= 10;
        }

        return true; // Bütün rəqəmlər fərqlidir
    }
}

