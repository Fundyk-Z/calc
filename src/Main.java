import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, Integer> keyArabic = Map.of(
    "I", 1, "II",2, "III",3, "IV",4, "V",5, "VI",6, "VII",7, "VIII",8, "IX",9, "X", 10);
    public static Map<Integer,String> keyRoman = Map.of(
            1, "I", 2,"II", 3,"III",  4,"IV", 5,"V", 6,"VI", 7,"8", 9,"IX", 10, "X",
            11, "XI", 12, "XII", 13, "XIII", 14, "XIV",15, "XV", 16, "XVI",17, "XVII",18, "XVII", 19, "XIX",
            20, "XX", 30, "XXX", 40, "XL", 50, "L", 60, "LX", 70, "LXX", 80, "LXXX", 90, "XC", 100, "C"
    );
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