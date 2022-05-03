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

        System.out.println( notOrt74BykUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayisi110AzMi(unv));
        System.out.println("\n   ***   ");
        System.out.println(matBolumVarmi(unv));

    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv) {

    return     unv.stream().allMatch(t -> t.getNotOrt() > 74);
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrcSayisi110AzMi(List<Universite> unv){

        return unv.stream().allMatch(t->t.getOgrcSayisi()>110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().
                anyMatch(t -> t.getBolum().toLowerCase().contains("mat"));

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.



        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder


    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

//akısdakş elamnalrın ortlaması alındı
        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
   //akısdaki elelman sayısını return eder
        //count();-->akısdaki elelman sayısını return eder


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.



    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.




}
