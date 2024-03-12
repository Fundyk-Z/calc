import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        startCalc();
    }
    public static Map<String, Integer> keyArabic = Map.of(
    "I", 1, "II",2, "III",3, "IV",4, "V",5, "VI",6, "VII",7, "VIII",8, "IX",9, "X", 10);

    public static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

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
        if (sum < 1) {
            System.out.println("Арабские числа не могут быть меньше 1");
            throw new RuntimeException();
        }
        return roman[sum];
    }

}