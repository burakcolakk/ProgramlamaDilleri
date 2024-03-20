import java.util.Scanner;

public class Gramer{
    public static void main(String[] args) {
        String[] ozne = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesne = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen bir cumle giriniz:");
        String cumle = scanner.nextLine().trim();

        cumle = cumle.replaceAll("\\s+", " ");

        String[] kelimeler = cumle.split("\\s");

        boolean dogruCumle = false;
        if (kelimeler.length >= 3) {
            String ozneKelime = kelimeler[0];
            String nesneKelime = kelimeler[1];
            String yuklemKelime = kelimeler[kelimeler.length - 1];

            if (containsIgnoreCase(ozne, ozneKelime) && containsIgnoreCase(nesne, nesneKelime) && containsIgnoreCase(yuklem, yuklemKelime)) {
                dogruCumle = true;
            }
        }

        if (dogruCumle) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
    }

    public static boolean containsIgnoreCase(String[] array, String key) {
        for (String element : array) {
            if (element.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }
}
