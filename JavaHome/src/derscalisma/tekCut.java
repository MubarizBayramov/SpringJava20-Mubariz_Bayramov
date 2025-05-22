package derscalisma;
import java.util.Scanner;
public class tekCut {


	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Neçə ədəd daxil etmək istəyirsiniz? N = ");
	        int n = scanner.nextInt();

	        int tekCem = 0;
	        int cutCem = 0;

	        for (int i = 1; i <= n; i++) {
	            System.out.print(i + ". ədədi daxil edin: ");
	            int eded = scanner.nextInt();

	            if (eded % 2 == 0) {
	                cutCem += eded;
	            } else {
	                tekCem += eded;
	            }
	        }

	        System.out.println("Tək ədədlərin cəmi: " + tekCem);
	        System.out.println("Cüt ədədlərin cəmi: " + cutCem);

	        scanner.close();
	    }
	}



