package JavaEsas;

public class operatoristifade {

	
	    public static void main(String[] args) {
	        int a = 10, b = 3;
	        
	        System.out.println("Toplama: " + (a + b));  // 13
	        System.out.println("Çıxma: " + (a - b));    // 7
	        System.out.println("Vurma: " + (a * b));    // 30
	        System.out.println("Bölmə: " + (a / b));    // 3 (tam bölmə)
	        System.out.println("Qalıq: " + (a % b));    // 1
	    }
	}

class AssignmentExample {
    public static void main(String[] args) {
        int x = 5;
        x += 3;  // x = x + 3 → 8
        x *= 2;  // x = x * 2 → 16
        System.out.println("Nəticə: " + x); // 16
    }
}

class ComparisonExample {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(a == b); // false
        System.out.println(a != b); // true
        System.out.println(a < b);  // true
    }
}

class LogicalExample {
    public static void main(String[] args) {
        boolean x = true, y = false;
        System.out.println(x && y); // false (çünki biri false-dur)
        System.out.println(x || y); // true (çünki biri true-dur)
        System.out.println(!x);     // false (x true idi, ! onu tərsinə çevirir)
    }
}

class IncrementExample {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(num++); // 5 (öncə çap edir, sonra artırır)
        System.out.println(num);   // 6
        System.out.println(--num); // 5 (öncə azaldır, sonra çap edir)
    }
}


