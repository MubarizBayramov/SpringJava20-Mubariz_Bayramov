package derscalisma;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sətir daxil edin: ");
        String input = scanner.nextLine();

        if (palindromMu(input)) {
            System.out.println("\"" + input + "\" palindromdur.");
        } else {
            System.out.println("\"" + input + "\" palindrom deyil.");
        }

        scanner.close();
    }

    public static boolean palindromMu(String str) {
        // Böyük-kiçik hərfləri fərqləndirməmək üçün hamısını kiçik hərfə çeviririk
        String temizStr = str.replaceAll("\\s+", "").toLowerCase();

        int sol = 0;
        int sag = temizStr.length() - 1;

        while (sol < sag) {
            if (temizStr.charAt(sol) != temizStr.charAt(sag)) {
                return false;
            }
            sol++;
            sag--;
        }

        return true;
    }
}
