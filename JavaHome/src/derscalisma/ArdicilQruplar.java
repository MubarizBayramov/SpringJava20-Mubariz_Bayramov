package derscalisma;

public class ArdicilQruplar {
    public static void main(String[] args) {
        int[] massiv = {1, 2, 3, 5, 6, 10};

        int qrupSayisi = ardicilQruplarinSayiniTap(massiv);
        System.out.println("Qrupların sayı: " + qrupSayisi);
    }

    public static int ardicilQruplarinSayiniTap(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int qrupSayisi = 1; // Ən az 1 qrup var
        for (int i = 1; i < arr.length; i++) {
            // Əgər cari ədəd əvvəlki ədəddən ardıcıl deyilsə, yeni qrup başlayır
            if (arr[i] != arr[i - 1] + 1) {
                qrupSayisi++;
            }
        }

        return qrupSayisi;
    }
}
