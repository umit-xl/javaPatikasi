import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.print("Yazmak istediğiniz sayı adedini giriniz : ");
        int n = inp.nextInt();

        if (n <= 0 ) {
            System.out.println("Lütfen geçerli bir adet giriniz.");
        }
        else {
            int [] numbers = new int[n];
            for (int i = 0; i < n; i++){
                System.out.print("Sayı " + (i + 1) + ": ");
                numbers[i] = inp.nextInt();
            }
            int min = numbers[0];
            int max = numbers[0];

            for (int i = 1; i<n; i++){
                if (numbers[i] < min){
                    min = numbers [i];
                }
                if (numbers[i] > max){
                    max = numbers[i];
                }
            }

            System.out.println("En küçük sayı : " + min);
            System.out.println("En büyük sayı : " + max);
        }



        /*

        String userName, password;
        Scanner input = new Scanner(System.in);

        int right = 3;
        int select;
        int balance = 1500;

        while (right > 0){
            System.out.print("Kullanıcı adınız : ");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            if (userName.equals("patika") && password.equals("dev123")){
                System.out.println("Sisteme giriş yaptınız.");
                do {
                    System.out.println("1 - Para Yatırma\n" +
                            "2 - Para çekme\n" +
                            "3 - Bakiye sorgulama\n" +
                            "4 - Çıkış yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = input.nextInt();
                    if (select == 1){
                        System.out.print("Tutar giriniz : ");
                        int price = input.nextInt();
                        balance += price;
                    }
                    else if (select == 2){
                        System.out.print("Tutar giriniz :");
                        int price = input.nextInt();
                        if (price > balance){
                            System.out.println("Hesabınızda bulunan tutardan daha yüksek bir tutar girdiniz. Tekrard deneyiniz");
                        }
                        else{
                            balance -= price;
                        }

                    }
                    else if (select ==3){
                        System.out.println("Bakiyeniz : " + balance);
                    }
                }
                while (select != 4);
                System.out.println("Tekrar görüşmek üzere");
                break;

            }

            else{
                right--;
                System.out.println("Hatalı kullanıcı adı veye şifre. Tekrar deneyiniz.");
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur.");
                }
                else {
                    System.out.println("Kalan hakkınız : " + right);
                }
            }
        }

        */



        /*

        int k;
        Scanner inp = new Scanner(System.in);

        System.out.print("Sayı giriniz : ");
        k = inp.nextInt();

        for (int i = 1; i <=k ; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }

        */

        /*
        Scanner inp = new Scanner(System.in);
        System.out.print("Mesafeyi km türünden giriniz : ");
        int mesafe = inp.nextInt();
        System.out.print("Lütfen yaşınızı giriniz : ");
        int yas = inp.nextInt();
        System.out.print("Yolculuk tipini giriniz (Tek yön => 1 , Çift yön => 2) : ");
        int yolculukTipi = inp.nextInt();
        String hataliGiris = "Hatalı Veri Girdiniz";
        if (mesafe > 0 || yas > 0 || yolculukTipi > 0 && yolculukTipi < 3) {
            double yasIndirimOranlari;
            if (yas <= 12) {
                yasIndirimOranlari = 0.5;
            } else if (yas > 12 && yas <= 24) {
                yasIndirimOranlari = 0.1;
            } else if (yas >= 65) {
                yasIndirimOranlari = 0.3;
            } else {
                yasIndirimOranlari = 0.0;
            }

            double yolculukTipiIndirimOranlari;
            if (yolculukTipi == 2) {
                yolculukTipiIndirimOranlari = 0.2;
            } else {
                yolculukTipiIndirimOranlari = 0.0;
            }

            double normalTutar = (double)mesafe * 0.1;
            double yasIndirimi = normalTutar * yasIndirimOranlari;
            double indirimliTutar = normalTutar - yasIndirimi;
            double yolculukTipiIndirimi = indirimliTutar * yolculukTipiIndirimOranlari;
            double toplamTutar = (indirimliTutar - yolculukTipiIndirimi) * (double)yolculukTipi;
            System.out.println(toplamTutar);
        } else {
            System.out.println(hataliGiris);
        }

        */

    }
}
