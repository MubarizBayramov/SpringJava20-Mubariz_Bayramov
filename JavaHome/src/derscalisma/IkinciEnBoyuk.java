package derscalisma;
public class IkinciEnBoyuk {
    public static void main(String[] args) {
        int[] massiv = {12, 45, 7, 89, 45, 90, 67};

        int ikinciEnBoyuk = tapIkinciEnBoyuk(massiv);

        System.out.println("Massivin ikinci ən böyük ədədi: " + ikinciEnBoyuk);
    }

    public static int tapIkinciEnBoyuk(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Massivdə ən azı iki element olmalıdır.");
        }

        int birinciMax = Integer.MIN_VALUE;
        int ikinciMax = Integer.MIN_VALUE;

        for (int eded : arr) {
            if (eded > birinciMax) {
                ikinciMax = birinciMax;
                birinciMax = eded;
            } else if (eded > ikinciMax && eded < birinciMax) {
                ikinciMax = eded;
            }
        }

        if (ikinciMax == Integer.MIN_VALUE) {
            throw new RuntimeException("Massivdə ikinci ən böyük ədəd tapılmadı (bütün ədədlər bərabər ola bilər).");
        }

        return ikinciMax;
    }
}
