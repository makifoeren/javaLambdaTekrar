import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_Lambda {

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        printElStuructured(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n *** ");
        printElFunctional(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n *** ");
        printElFunctional1(sayi); //342216113520632165446664813815
        System.out.println("\n *** ");
        printElFunctional2(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n *** ");
        ciftElStructured(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n *** ");
        printCiftElFunctional1(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n *** ");
        printCiftOtuzdorttenKucukFunctional(sayi); //22 16 20
        System.out.println("\n *** ");
        printCiftOtuzdorttenBuyukFunctional(sayi); //44 66 64 38
    }

    // Task : Structured Programming kullanarak elemanlari aralarinda bosluk olacak sekilde print ediniz

    public static void printElStuructured(List<Integer> sayi) {

        for (Integer w : sayi) {
            System.out.print(w + " ");
        }

    }
    // Task : Functional Programming kullanarak elemanlari aralarinda bosluk olacak sekilde print ediniz

    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));
// sayi si alip stream ile akis a dikine koyup herbir elemani aksiyona sokuyoruz
    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);
        // gelecek sayilari akisa al print et bunun adin method reference
        // System.ou clasindn print i refere et
        // bu action task daki ayni sattira ve
        // bosluk ile yazmayi karsilamaz bunun icin seed (tohum )
        //  method create edilip refere edilmeli
        // ne yapacagini soyler
    }

    public static void yazdir(int a) { // verilen int degeri ayni satirda bosluk birakarak
        // yazdirma aksiyoni yapan seed (tohum) methodu create edildi

        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(C01_Lambda::yazdir);
        // : noktanin sol kaynak sag ref- method :: snytex

    }

//structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void ciftElStructured(List<Integer> sayi) {

        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");

            }
        }
    }
        //functionalProgramming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

        public static void printCiftElFunctional (List < Integer > sayi) {
        sayi.stream().filter(t-> t%2==0).forEach(C01_Lambda::yazdir);

        }

    public static boolean ciftbul(int a) { // seed method kendisine verilen int degerinin cift olup olmamasini kontrol eder

        return a % 2 == 0;

    }

    public static void printCiftElFunctional1(List<Integer> sayi) {

        sayi.
                stream(). // list elemanlari akisa alindi
                filter(C01_Lambda::ciftbul). // cift bul method refere edilerek akistaki elemnlar filtrelendi cift sayiya gore
                forEach(C01_Lambda::yazdir); // filtre den gelen elemanlar yazdir method refere edilererek print edildi
    }

    //functionalProgramming ile list elemanlarinin  cift olanalrini 34 ten kucuk ayni satirda aralarina bosluk
    // birakarak print ediniz.

    public static void printCiftOtuzdorttenKucukFunctional(List<Integer> sayi){
        sayi.stream().  //  filter(t -> t % 2 == 0).
                filter(C01_Lambda::ciftbul).
                filter(t-> t<34).
                forEach(C01_Lambda::yazdir);
    }

    // 34 ten buyuk

    public static void printCiftOtuzdorttenBuyukFunctional(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 || t>34). //34 22 16 35 20 63 65 44 66 64 81 38
                //filter(C01_Lambda::ciftbul).filter(t-> t>34). // 44 66 64 38
        forEach(C01_Lambda::yazdir);
    }


}
