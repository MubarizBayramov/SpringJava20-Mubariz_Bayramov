package JavaEsas;
public class saySistemleri {
    
    // Onluq ədədini 8-lik (oktal) say sisteminə çevirən metod
    public static String decimalToOctal(int decimal) {
        // Integer.toOctalString() metodu ilə onluq ədədini 8-lik sistemə çeviririk
        return Integer.toOctalString(decimal);
    }
    
    public static void main(String[] args) {
        int decimalNumber = 65; // Onluq ədəd
        String octalNumber = decimalToOctal(decimalNumber); // 8-lik sistemə çeviririk
        
        System.out.println("Onluq ədəd: " + decimalNumber); // 65
        System.out.println("8-lik (oktal) ədəd: " + octalNumber); // 101
    }
    
    
    public class UnicodeExample {
        public static void main(String[] args) {
            String message = "Hello, \u4F60\u597D!"; // Unicode ilə Çin simvollarını əlavə edirik
            System.out.println(message); // Çap edir: Hello, 你好!
        }
    }

}

