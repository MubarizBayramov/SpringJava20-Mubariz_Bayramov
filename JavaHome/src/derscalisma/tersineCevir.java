package derscalisma;
import java.util.Scanner;
public class tersineCevir {

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Bir söz daxil edin: ");
	        String soz = scanner.nextLine();
	        String tersSoz = "";

	        for (int i = soz.length() - 1; i >= 0; i--) {
	            tersSoz += soz.charAt(i);
	        }

	        System.out.println("Sözün tərsi: " + tersSoz);

	        scanner.close();
	    }
	}


