package derscalisma;

public class EnBoyukEnKicik {

	
	
	    public static void main(String[] args) {
	        int[] massiv = {12, 5, -3, 25, 7, 0, 19};

	        int enBoyuk = massiv[0];
	        int enKicik = massiv[0];

	        for (int i = 1; i < massiv.length; i++) {
	            if (massiv[i] > enBoyuk) {
	                enBoyuk = massiv[i];
	            }
	            if (massiv[i] < enKicik) {
	                enKicik = massiv[i];
	            }
	        }

	        System.out.println("Ən böyük ədəd: " + enBoyuk);
	        System.out.println("Ən kiçik ədəd: " + enKicik);
	    }
	}


