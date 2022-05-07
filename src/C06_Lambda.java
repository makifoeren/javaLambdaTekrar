import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C06_Lambda {

    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\nTASK 01 -->*** haluk.txt dosyasini okuyunuz -->  ");

        Path haluk = Path.of("src/haluk.txt");// path haluk obj atandi
        Stream<String> akis = Files.lines(haluk);//haluk.txt datalari akis stream e atandi
//1.yol
        Files.lines(Paths.get("src/haluk.txt")).  //Files class dan lines() method call
                // edilerek data cekilecek dosya yolu(path) parametre girilerek
                // path deki dosyalanin data lari akisa alindi
                        forEach(System.out::println);
//2.yol
        akis.forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\nTASK 02 -->*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/haluk.txt")).  //Files class dan lines() method call
                // edilerek data cekilecek dosya yolu(path) parametre girilerek
                // path deki dosyalanin data lari akisa alindi
                        map(String::toUpperCase).// data lar buyuk harfe ubdate edildi
                forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\nTASK 03 -->*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz  -->  ");
//1. yol
        Files.lines(haluk).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);

        //2. yol findFirst();
        System.out.println(Files.lines(haluk).
                map(String::toLowerCase).
                findFirst());

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\nTASK 04 -->*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.lines(haluk).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..
        System.out.println("\nTASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
/*
   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

 */

        //1. yol.. distinct()
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                        flatMap(Arrays::stream).//2D arraydaki elelmanlar tek eleman olarak akısa alındı
                        distinct().//akısdaki elemanlar tekrarsız yapıldı
                        collect(Collectors.toList()));//akısdaki tekrarsız elemanlar liste atandı

        //2. yol.. toset()
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                        flatMap(Arrays::stream).
                collect(Collectors.toSet()));


//TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..
        System.out.println("\nTASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                flatMap(Arrays::stream).//2D arraydaki elelmanlar tek eleman olarak akısa alındı
                sorted().//harf sırası yapıldı
                forEach(System.out::println);//print edildi

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\nTASK 07 -->*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\nTASK 08 -->*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).// dosyaya erisim alindi
                map(t -> t.split(" ")).//satirlsr akisa alindi
                flatMap(Arrays::stream).//her satirda her kelime akisa alindi
                filter(t -> t.contains("a")).//a bulunduran kelimeler filtrelendi
                count());//a bulunan kelimeler sayildi


        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\nTASK 09 -->*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).// dosyaya erisim alindi
                map(t -> t.split(" ")).//satirlsr akisa alindi
                flatMap(Arrays::stream).//her satirda her kelime akisa alindi
                filter(t -> t.contains("a")).//a bulunduran kelimeler filtrelendi
                collect(Collectors.toList()));
        //  forEach(System.out::println);

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\nTASK 10 -->*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split("")).
                flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\nTASK 11 -->*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split(" ")).// kelime akisi
                        flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                flatMap(Arrays::stream).
                distinct().forEach(System.out::println);



    }
}
