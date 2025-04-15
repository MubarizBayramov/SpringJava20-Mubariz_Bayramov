package ExceptionHandling;

public class throwThrows {
	
	    // Metod, yaş mənfi olarsa, istisna atacaq
	    static void checkAge(int age) throws IllegalArgumentException {
	        if (age < 0) {
	            throw new IllegalArgumentException("Yaş mənfi ola bilməz!");
	        }
	        System.out.println("Yaş düzgündür: " + age);
	    }

	    public static void main(String[] args) {
	        try {
	            checkAge(-5);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Xəta: " + e.getMessage());
	        }
	    }
	}


