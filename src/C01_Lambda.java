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


    }

            // Task : Structured Programming kullanarak elemanlari aralarinda bosluk olacak sekilde print ediniz

   public static void printElStuructured( List<Integer> sayi ){

       for (Integer w:sayi) {
           System.out.print(w+" "); }

    }
    // Task : Functional Programming kullanarak elemanlari aralarinda bosluk olacak sekilde print ediniz

    public static void printElFunctional(List<Integer> sayi){
        sayi.stream().forEach(t-> System.out.print(t+" ") );
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

















}
