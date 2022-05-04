import java.util.*;
import java.util.stream.Collectors;

public class C04_Lambda {
    public static void main(String[] args) {
         /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */

        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1453, 71);
        Universite u04 = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite u05 = new Universite("yıldız teknik", "gemi", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayisi110AzMi(unv));
        System.out.println("\n   ***   ");
        System.out.println(matBolumVarmi(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayiBkSirala(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrtBkSiralailk3(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrenSayisiAzIkinci(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrt63tenBuyukOgrnciSayTopla(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrt63BykUnvOgrcSayisiToplaToInt(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayisi333BykNotOrtOrtlamaAl(unv));
        System.out.println("\n   ***   ");
        System.out.println(mathBolmSayısı(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayisi571BykMaxNotort(unv));
        System.out.println("\n   ***   ");
        ogrcSayisi1071AzMinnotOrt(unv);

    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.stream().allMatch(t -> t.getNotOrt() > 74);
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {

        return unv.stream().allMatch(t -> t.getOgrcSayisi() > 110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().
                anyMatch(t -> t.getBolum().toLowerCase().contains("mat"));

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayiBkSirala(List<Universite> unv) {

        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrcSayisi).reversed()).
                collect(Collectors.toList());// liste topla //collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlari list'e cevirir

    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBkSiralailk3(List<Universite> unv) {

        return unv.stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()). // not ortalamasina gore b>k siraladi
                        limit(3).// ilk 3 eleman
                        collect(Collectors.toList());// liste topla //akısın ilk 3 elemanı list'e assign edildi
        //toList());//akısın ilk 3 elemanı list'e assign edildi
    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static List<Universite> ogrenSayisiAzIkinci(List<Universite> unv) {

        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrcSayisi)).
                limit(2).// en az nufusu olan iki unv veriri
                        skip(1). // 1. yi atar 2 yi verir
                        collect(Collectors.toList()); // akisa gelenleri parantez icindeki parametreye gore toplar

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.
    public static int notOrt63tenBuyukOgrnciSayTopla(List<Universite> unv) {

        return unv.stream().
                filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrcSayisi()).
                // reduce(Integer::sum);
                //reduce(Math::sum);
                        reduce(0, (t, u) -> t + u);

    }

    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrcSayisi()).
                sum();
        // mapToInt() --> bu method akısdaki elemanların data type'nı degistirir int e ceviriyor
        // parameterisindeki() degere göre Int data type update eder
    }


    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

    public static OptionalDouble ogrcSayisi333BykNotOrtOrtlamaAl(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getOgrcSayisi() > 333).mapToDouble(t -> t.getNotOrt()).
                average(); //ortalama
    }
//akısdakş elamnalrın ortlaması alındı
    // mapToDouble() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki degere göre dooble data type update eder


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int mathBolmSayısı(List<Universite> unv) {

        return (int) unv.stream().
                filter(t -> t.getBolum().contains("mat")).
                count(); // saydir methodu
        //akısdaki elelman sayısını return eder
        //count();-->akısdaki elelman sayısını return eder
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalDouble ogrcSayisi571BykMaxNotort(List<Universite> unv) {

        return unv.stream().
                filter(t -> t.getOgrcSayisi() > 571). // unv obj akisis filtrelendi
                        mapToDouble(t -> t.getNotOrt()).// akistaki unv obj not ortalamasi update edildi
                        max();
    }


    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static void ogrcSayisi1071AzMinnotOrt(List<Universite> unv) {
        System.out.println(  unv.stream().
                filter(t -> t.getOgrcSayisi() < 1071).mapToDouble(t -> t.getNotOrt()).
                min());
    }
}