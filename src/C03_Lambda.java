import java.util.*;
import java.util.stream.Stream;

import static java.awt.SystemColor.menu;

public class C03_Lambda {


    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kuslemex", "adana", "trilece","trilece","trilece", "havuCDilimi", "BurYan",
                "yaglama", "kokorecx", "warabaSI", "guvec"));

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
        charKaresiCiftElPrint(menu); //
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanKontrol(menu);
        System.out.println("\n   ***   ");
        xIleBitenKontrol(menu);
        System.out.println("\n   ***   ");
        charSayisiBykElPrint(menu);
        System.out.println("\n   ***   ");
        ilkElHarcSonHrfSiraliPrint(menu);
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
// comparing karsilastirma
        // reverse ters sirali
    }
 // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini
    // tekrarsiz buyukten kucuge sirali  print ediniz..
 public static void  charKaresiCiftElPrint(List<String> menu){
        menu.stream().
                map(t->t.length()*t.length()).
                filter(C01_Lambda::ciftbul).
                distinct().
                sorted(Comparator.reverseOrder()).  // buyukten kucuge sirlama
                forEach(C01_Lambda::yazdir);
 }

// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.


    public static void harfSayisi7denAzKontrol(List<String> menü) {

        boolean kontrol = menü.stream().
                allMatch(t -> t.length() <= 7); // akisa aldigin herbir elemani Match et
// hepsini kontrol et karakter sayisi 7 den kucuk mu
        if (kontrol) {
            System.out.println("List elemanlari 7 ve daha az harften olusuyor");
        } else
            System.out.println("List elemanlari 7 harften buyuk ");

        System.out.println(kontrol);

        System.out.println(menü.stream().allMatch(t -> t.length() <= 7) ?
                "List elemanlari 7 ve daha az harften olusuyor" : "List elemanlari 7 harften buyuk ");

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //

        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

public static void wIleBaslayanKontrol(List<String> menü) {

    System.out.println(menü.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan hic yemek yok" :
            "w ile baslayan en az bir tane yemek var ");
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
}//w ile baslayan yemek yok

// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

    public static void xIleBitenKontrol(List<String> menü) {

        System.out.println(menü.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten yemegin menude var" :
                "x ilw biten yemek yok");

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //x ile biten yemegin menude var
    }



// Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiBykElPrint(List<String> menü) {

        Stream<String> sonIsim = menü.stream().
                sorted(Comparator.comparing(t -> t.toString().length()). // length lere gore siraladi
                        reversed()). // ters sirala
                // findFirst()); //  karakter sayisi en buyuk olani verri
                        limit(1);//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır

        /*
sonIsim.toArray() --> limit() meth dan dolayi stream type olan sonIsim toArray()
method ile array type convert edildi */
        System.out.println(Arrays.toString(sonIsim.toArray())); // arraya cevrilen sonIsim stream print edildi

        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder.
        Optional<String> enBykKrEl = (menü.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst()); //ilk elemani alir


    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHarcSonHrfSiraliPrint(List<String> menü) {
        menü.stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))) // son harfe gore siralandi
                .skip(1).// ilk eleman atlandi 1.haric
                forEach(t -> System.out.println(t + " "));

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }
}