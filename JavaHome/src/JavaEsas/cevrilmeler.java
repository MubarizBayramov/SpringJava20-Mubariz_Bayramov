package JavaEsas;

public class cevrilmeler {


    public static void main(String[] args) {
        int say = 100;
        double d = say; // Avtomatik çevrilmə (int → double)
        System.out.println(d); // 100.0
    }
}



    class cevrilmeler1 {
    public static void main(String[] args) {
    double d = 150;
    int i = (int) (d);  // Məcburi çevrilmə (double → int)
    System.out.println(i);
     
    }
    
}
