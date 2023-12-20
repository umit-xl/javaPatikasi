import java.util.Scanner;

public class AsalSayi {
    //Recursive kontrolü
    static boolean asalKontrol (int sayi, int bolen){
        if (bolen == sayi){
            return true;
        }
        if (sayi % bolen == 0){
            return false;
        }
        return asalKontrol(sayi, bolen + 1);
    }
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int sayi;
        System.out.print("Bir sayı giriniz : ");
        sayi = inp.nextInt();

        if (sayi < 2) {
            System.out.print(sayi + " Asal değildir.");
        }
        else {
            if (asalKontrol(sayi,2)){
                System.out.print(sayi + " Asal sayıdır.");
            }
            else {
                System.out.print(sayi + " Asal değildir.");
            }
        }

    }

}

