import java.util.*;

public class C02_Lambda {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        cifElKare(sayi);//16 4 36
        System.out.println("\n ***");
        tekKupBirFazlaPrint(sayi); //1332 -124 344 28 3376
        System.out.println("\n ***");
        ciftKarekokPrint(sayi); //2.0 1.4142135623730951 2.449489742783178
        System.out.println("\n ***");
        maxEl(sayi); // Optional[15]
        System.out.println("\n ***");
        ciftElemanKareBuyugu(sayi);
        System.out.println("\n ***"); //Optional[36]
        elTopla(sayi);
        System.out.println("\n ***");
        ciftElemanlarinCarpimi(sayi); // 48
        System.out.println("\n ***");
        minBul(sayi); // Optional[-5]
        System.out.println("\n ***");
        bestenBykEnKck(sayi); //5 ten Byk en kucuk sayi ve tek :Optional[7]
        System.out.println("\n ***");
        ciftKareKbPrint(sayi); // 4 16 36
        System.out.println("\n ***");
        tekKareBkPrint(sayi); //225 121 49 25 9
        System.out.println("\n ***");

    }

    // Task : Functional Programming ile listin cift elemanlarinin
    // karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void cifElKare(List<Integer> sayi) {

        sayi.stream().filter(C01_Lambda::ciftbul).map(t -> t * t).forEach(C01_Lambda::yazdir);

        // filter le secme var aktion yok -- map ise icine koydugumuz islemi yapar
        ////map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya
        // üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
    }

    // Task : Functional Programming ile listin tek elemanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.stream().
                filter(t -> t % 2 != 0). // tek elemanlar
                map(t -> t * t * t + 1).// kup ler
                forEach(C01_Lambda::yazdir);// yazdirma
    }

// Task : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(C01_Lambda::ciftbul).
                map(Math::sqrt). // hazrdakini aldik karekok meth kullandik
                //forEach(Lambda01::yazdir) yazdir methodu int oldugu icun kabul etmiyor elle yazdik
                        forEach(t -> System.out.print(t + " ")); // exspre
    }

    // Task : list'in en buyuk elemanini yazdiriniz

    public static void maxEl(List<Integer> sayi) {  // eger sonuc ta tek elemn elde ediyorsa reduce() kullanilir

        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);

        System.out.println(maxSayi); // 15 vareible ye baglayip yaptik

        System.out.println(sayi.stream().reduce(Math::max)); //15 deger atamadan
    }
//  Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftElemanKareBuyugu(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(C01_Lambda::ciftbul).
                map(t -> t * t).
                reduce(Math::max)); // Optional[36] daha buyuk bir klass

        System.out.println(sayi.
                stream().
                filter(C01_Lambda::ciftbul).
                map(t -> t * t).
                reduce(Integer::max)); // Optional[36] specific class daha hizli run olur daha dar daha hizli calisir
    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...

    public static void elTopla(List<Integer> sayi) {

        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Lambda exp : " + toplam); // exp creat


        sayi.stream().reduce(Integer::sum); // method ref
        System.out.println("met ref :" + sayi.stream().reduce(Integer::sum)); // method Expression

 /*
        a ilk degerini her zaman atanan degerden (identity) alir
        b degerini her zaman stream ()dan alir
        a ilk degerinden sonraki her degeri action (islem ) den alir
       */


    }
// Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftElemanlarinCarpimi(List<Integer> sayi) {

        // method Expression
        System.out.println("met ref :" + sayi.stream().filter(C01_Lambda::ciftbul).reduce(Math::multiplyExact)); // Optional[48]

        //Lambda Expression.
        int carpim = sayi.stream().filter(C01_Lambda::ciftbul).reduce(1, (a, b) -> (a * b));
        System.out.println(carpim);

    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
//1. yontem Method Reference --> Integer class
//2. yontem Method Reference --> Math class
//3. yontem Lambda Expression
//4. yontem Method Reference --> Haluk class

    private static void minBul(List<Integer> sayi) {

        Optional<Integer> minSayiInt = sayi.stream().reduce(Integer::min);
        System.out.println("1. yontem : " + minSayiInt);

        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println("2. yontem : " + minSayiMath);

        Optional<Integer> minSayiLJambda = Optional.of(sayi.stream().reduce(Integer.MAX_VALUE,
                (x, y) -> x < y ? x : y));
        System.out.println("3. yontem : " + minSayiLJambda);

        Optional<Integer> minSayiHaluk = sayi.stream().reduce(C02_Lambda::byHalukMin);

        System.out.println("4. yontem : " + minSayiHaluk);
    }

    public static int byHalukMin(int a, int b) { // iki int degerden en kucugunu return eder

        return a < b ? a : b;

    }
// Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykEnKck(List<Integer> sayi) {

        Optional<Integer> bestenBykEnKck = sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(C02_Lambda::byHalukMin);

        System.out.println("5 ten Byk en kucuk sayi ve tek :" + bestenBykEnKck);
    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftKareKbPrint(List<Integer> sayi) {

        sayi.stream().filter(C01_Lambda::ciftbul).map(t -> t * t).sorted().forEach(C01_Lambda::yazdir);
       /* sayi.
                stream(). // akisa alind
                filter(C01_Lambda::ciftbul). //filtrelendi
                map(t -> t * t).// filtrenen cift sayi karesi alindi
                sorted(). //karesi alinanlar dogal siralandi
                forEach(C01_Lambda::yazdir);//print edildi
        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.*/

    }

// Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.//akıs kaynagı
                stream().//akısa alındı
                filter(t -> t % 2 != 0).//tek elemnlar fitrlenedi
                map(t -> t * t).//fitrelenen cift sayı karesi alındı
                sorted(Comparator.reverseOrder()).//karesi alınan elemanlar ters(b->k) sıralandı
                forEach(C01_Lambda::yazdir);//print edildi
    }

}
