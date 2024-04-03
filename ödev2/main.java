import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adini girin: ");
        String dosyaAdi = scanner.nextLine();
       
        int[] sayilar = new int[15];
        int[] indeksler = new int[15];

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            int index = 0;
            while ((satir = br.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                sayilar[index] = sayi; 
                indeksler[index] = index;
                index++;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            return;
        }

        System.out.println("Dosyadan okunan veriler:");
        yazdir(sayilar, indeksler);

            for (int i = 0; i < sayilar.length - 1; i++) {
            for (int j = 0; j < sayilar.length - i - 1; j++) {
                if (sayilar[j] > sayilar[j + 1]) {
                  
                    int geciciSayi = sayilar[j];
                    sayilar[j] = sayilar[j + 1];
                    sayilar[j + 1] = geciciSayi;

                    int geciciIndeks = indeksler[j];
                    indeksler[j] = indeksler[j + 1];
                    indeksler[j + 1] = geciciIndeks;
                }
            }
        }

        System.out.println("Siralanmis sayilar ve indexleri:");
        yazdir(sayilar, indeksler);
    }

    static void yazdir(int[] sayilar, int[] indeksler) {
        for (int i = 0; i < sayilar.length; i++) {
            if (sayilar[i] != 0) {
                System.out.println("Sayi: " +sayilar[i] + "\t" + " Index: " + indeksler[i]);
            }
        }
    }
}