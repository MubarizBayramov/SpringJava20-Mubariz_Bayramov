package JavaEsas;

public class UniCode {

	
	    public static void main(String[] args) {
	        char letter = '\u0041';// Unicode ilə 'A' simvolunu təyin edirik
	       
	        char heart = '\u2764';  // Unicode ilə ürək simvolu
	        char smile = '\u263A';  // Unicode ilə gülümsəyən simvol

	        
	        char euroSymbol = '\u20AC';  // Unicode ilə avro simvolu
	        char yenSymbol = '\u00A5';   // Unicode ilə yen simvolu

	        System.out.println("Euro symbol: " + euroSymbol); // Çap edir: Euro symbol: €
	        System.out.println("Yen symbol: " + yenSymbol);   // Çap edir: Yen symbol: ¥
	        System.out.println("Heart: " + heart);  // Çap edir: Heart: ❤
	        System.out.println("Smile: " + smile);  // Çap edir: Smile: ☺
	        System.out.println(letter); // Çap edir: A
	    }
	}


