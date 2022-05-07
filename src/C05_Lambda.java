import java.util.stream.IntStream;

public class C05_Lambda {
    public static void main(String[] args) {


        System.out.println("TASK 01 STr-->" + toplaStrile(10));
        System.out.println("TASK 01 FUc-->" + toplaFunile(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + toplaCift(10)); //2+4+6+8+10
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkXCift(10)); //2+4+6....18+20
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + toplaIlkXTek(10));
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(10);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenenSayiXKuvvetPrint(4, 3);
        System.out.println("   ***   ");
        istenenSayiXKuvvetPrint(3, 4);
        System.out.println("   ***   ");
        istenenSayiXKuvvetPrint(1453, 1);
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->" + istenenSayiFaktoriyeliPrint(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->"+xKuvveti(4,3));
        System.out.println("   ***   ");


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming

    public static int toplaStrile(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix Programming

    public static int toplaFunile(int x) {

        return IntStream. // interface dir int akis olusturuyor sonra range ile sinirlarini veriyoruz
                range(1, x + 1). // 1 den x e kadar (x dahil) int degerler akisa alindi
                        sum();// akistadikler toplandi
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x) {

        return IntStream.
                rangeClosed(1, x). // 1 den x e kadar (x dahil) int degerler akisa alindi
                        filter(C01_Lambda::ciftbul). //akistaki cift int degerler akisa alindi
                        sum();// akistadikler toplandi
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int toplaIlkXCift(int x) {

        return IntStream.
                iterate(2, t -> t + 2).// 2 den sonsuz akadar 2 artirarark akisa alir
                        limit(x). // akistaki ilk x degeri akisa alir
                        sum();// akistadikler toplandi

        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int toplaIlkXTek(int x) {

        return IntStream.
                iterate(1, t -> t + 2).// 1 den sonsuz akadar 2 artirarark akisa alir
                        limit(x). // akistaki ilk x degeri akisa alir yani x te kaeser
                        sum();// akistadikler toplandi
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininIlkXKuvvetPrint(int x) {

        IntStream.
                iterate(2, t -> t * 2).//2 den sonsuz akadar elemalari 2 ile carparak akisa alir 2,4,8,16,...
                limit(x). // akistaki ilk x degeri akisa alir yani x te kaeser
                forEach(C01_Lambda::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenenSayiXKuvvetPrint(int istenenSayi, int x) {

        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).//2 den sonsuz akadar elemalari 2 ile carparak akisa alir 2,4,8,16,...
                limit(x). // akistaki ilk x degeri akisa alir yani x te kaeser
                forEach(C01_Lambda::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenenSayiFaktoriyeliPrint(int x) {

        return IntStream.
                rangeClosed(1, x).
                // reduce(Math::multiplyExact).
                        reduce(1, (t, u) -> t * u);
    }
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int xKuvveti(int istenenSayi, int x){
        return IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).
                reduce(0,(t,u)->u);
    }
    /*public static double xKuvveti (int istenenSayi, int x) {
        return Math.pow(istenenSayi,x);

    }*/

}

