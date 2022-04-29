import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C03_Lambda {

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
// Task : Karakter sayisi en buyuk elemani yazdiriniz.
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.


    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece","trilece","trilece", "havuCDilimi", "BurYan",
                "yaglama", "kokorec", "arabaSI", "guvec"));

        System.out.println(menu);
        System.out.println("\n   ***   ");
        alfBykTekrrsz(menu); // ADANA ARABASI BURYAN GUVEC HAVUCDILIMI KOKOREC KUSLEME TRILECE YAGLAMA
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu); //11 7 6 5
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu); //adana guvec BurYan kusleme trilece trilece trilece yaglama kokorec arabaSI havuCDilimi
        //ADANA GUVEC BURYAN KUSLEME TRILECE YAGLAMA KOKOREC ARABASI HAVUCDILIMI
        System.out.println("\n   ***   ");
        sonHrfBkSirali(menu); //BurYan havuCDilimi kusleme trilece trilece trilece kokorec guvec adana yaglama arabaSI
        System.out.println("\n   ***   ");
    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfBykTekrrsz(List<String> yemek) {
        yemek.stream().
                // map(t -> t.toUpperCase()). LAmbda ex elemanlar buyuk harf update edildi
                map(String::toUpperCase). // meth ref elemanlar buyuk harf update edildi
                sorted(). //sorted dogal sirala alfabetik siraladi
                distinct(). // tekrarsiz benzersiz  halde sirala
                forEach(t -> System.out.print(t + " "));
        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // task: list elemanlarinin chracter saiyisni ters sirali olarak tekrarsiz olarak print

    public static void chrSayisiTersSirali(List<String> menu) {

        menu.stream().
                map(String::length). // elemanlarin karakter sayisi update edildi
                //map(t-> t.length()).
                sorted(Comparator.reverseOrder()).// ters sira edildi
                distinct(). // benzersi
                forEach(C01_Lambda::yazdir);
        //  forEach(t -> System.out.print(t + " "));

    }
// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void chrSayisiBkSirala(List<String> menu) {
        menu.stream().
                map(String::toUpperCase).
                sorted(Comparator. // sirala sonra denilene gore karsilastir
                comparing(String::length)). // comparing karsilastima  methodu dur length ine gore
                distinct().
                forEach(t -> System.out.print(t + " ")); // string oldugu icin elle yazacaz
    }
    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.

    public static void sonHrfBkSirali(List<String> menu) {
        menu.stream().
                sorted(Comparator.
                comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()). // son harfine gore siralayip reverse ile ters ceviri
                forEach(t -> System.out.print(t + " "));

        // reverse ters sirali
    }



}