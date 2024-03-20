import java.util.Scanner;

public class Gramer {

    private static final String[] OZNE = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
    private static final String[] NESNE = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
            "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
    private static final String[] YUKLEM = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cümleyi giriniz: ");
        String cumle = scanner.nextLine().trim().replaceAll("\\s+", " ");

        String[] kelimeler = cumle.split("\\s+");
        if (kelimeler.length != 3) {
            System.out.println("Cümle hatalı! Üç kelimeden oluşmalıdır.");
            return;
        }

        boolean ozneVar = kelimeKontrolEt(kelimeler[0], OZNE);
        boolean nesneVar = kelimeKontrolEt(kelimeler[1], NESNE);
        boolean yuklemVar = kelimeKontrolEt(kelimeler[2], YUKLEM);

        if (ozneVar && nesneVar && yuklemVar) {
            System.out.println("Evet, cümle gramer kurallarına uyuyor.");
        } else {
            System.out.println("Hayır, cümle gramer kurallarına uymuyor.");
        }
    }

    private static boolean kelimeKontrolEt(String kelime, String[] dizi) {
        for (String eleman : dizi) {
            if (eleman.equalsIgnoreCase(kelime)) {
                return true;
            }
        }
        return false;
    }
}
