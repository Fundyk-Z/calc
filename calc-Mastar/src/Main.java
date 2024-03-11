import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer,String> keyRoman = new HashMap<>();
    public static Map<String, Integer> keyArabic = Map.of(
    "I", 1, "II",2, "III",3, "IV",4, "V",5, "VI",6, "VII",7, "VIII",8, "IX",9, "X", 10);

    static {
        keyRoman.put(1,"I");
        keyRoman.put(2,"II");
        keyRoman.put(3,"III");
        keyRoman.put(4,"IV");
        keyRoman.put(5,"V");
        keyRoman.put(6,"VI");
        keyRoman.put(7,"VII");
        keyRoman.put(8,"VIII");
        keyRoman.put(9,"IX");
        keyRoman.put(10,"X");
        keyRoman.put(11,"XI");
        keyRoman.put(12,"XII");
        keyRoman.put(13,"XIII");
        keyRoman.put(14,"XIV");
        keyRoman.put(15,"XV");
        keyRoman.put(16,"XVI");
        keyRoman.put(17,"XVII");
        keyRoman.put(18,"XVIII");
        keyRoman.put(19,"XIX");
        keyRoman.put(20,"XX");
        keyRoman.put(30,"XXX");
        keyRoman.put(40,"XL");
        keyRoman.put(50,"L");
        keyRoman.put(60,"LX");
        keyRoman.put(70,"LXX");
        keyRoman.put(80,"LXXX");
        keyRoman.put(90,"XC");
        keyRoman.put(100,"C");
    }

    public static void main(String[] args) {

        startCalc();
    }

    public static void startCalc(){
        Scanner console = new Scanner(System.in);
        System.out.println("Ожидания примера...");
        System.out.println(calc(console.nextLine()));
    }

    public static String calc(String input) {
        int sum = 0;
        int numberOfArabic = 0;

        String[] array = input.split(" ");
        if (array.length != 3) {
            System.out.println("Вы допустили ошибку при вводе примера.");
            throw  new RuntimeException();
        }

        for(String stt : keyArabic.keySet()) {
            if (array[0].equals(stt)){
                array[0] = String.valueOf(keyArabic.get(stt));
                numberOfArabic++;
            }
            if (array[2].equals(stt)) {
                array[2] = String.valueOf(keyArabic.get(stt));
                numberOfArabic++;
            }
        }

        if (numberOfArabic == 1) {
            System.out.println("Вы допустили ошибку при вводе примера.");
            throw new RuntimeException();
        }
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[2]);

        if (x > 10 || x < 1 || y > 10 || y < 1) {
            System.out.println("Какое-то или какие то числа больше 10 или меньше 0");
            throw new RuntimeException();
        }

        sum = calculations(array[1],x,y);

        if (numberOfArabic == 2) {
            return RomanToArabic(sum);
        }
            return String.valueOf(sum);
    }

    public static Integer calculations(String sign, int x, int y){
        switch (sign){
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "/":
                return x / y;
            case "*":
                return x * y;
        }
        return null;
    }

    public static String RomanToArabic(int sum){
        StringBuilder stringBuilder = new StringBuilder();
        if (sum < 1) {
            System.out.println("Арабские числа не могут быть меньше 1");
            throw new RuntimeException();
        }
        return keyRoman.get(sum);
    }

}