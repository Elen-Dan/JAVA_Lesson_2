/**
 * Homework_2
1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
7. **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
 */
import java.util.Random;

 public class Homework_2 {
    public static void main(String[] args) {

        String strOne = "Мадам";
        String strTwo = "Модный";

        int numberOne = 3;
        int numberTwo = 56;

        //Вызовы функций
        System.out.println("Вхождение одной строки: " + checkingTheString(strOne, strTwo));
        System.out.println("Являются ли строки палиндромом: " + palindromeString(strOne, strTwo));
        System.out.println("Разворот строки через рекурсию: " + reverseString(strTwo));
        System.out.println("Произвольная строка из заданых чисел: " + numString(numberOne, numberTwo));
        System.out.println("Метод замены символа с помощью insert: " + replaceSimbol(numString(numberOne, numberTwo)));
        System.out.println("Метод замены символа с помощью replace: " + replaceSimbolTwo(numString(numberOne, numberTwo)));
        System.out.println("Время выполнения метода замены символа с помощью replace String: " + replaceSimbolString(numString(numberOne, numberTwo)));
        System.out.println("Время выполнения метода замены символа с помощью replace StringBuilder: " + replaceSimbolStringBuilder(numString(numberOne, numberTwo)));
        ;

    }

    //Проверка вхождения одной строки в другую:
    public static boolean checkingTheString(String one, String two) {
        if (one.length() > two.length()) {
            return one.contains(two);
        } else return two.contains(one);
    }

    //Проверка является ли первая строка палиндромом второй:
    public static boolean palindromeString(String one, String two) {
        StringBuilder tempStr = new StringBuilder(two.toLowerCase()).reverse();
        String newStringReverse = tempStr.toString();
        return one.equalsIgnoreCase(newStringReverse);
    }

    //Метод рекурсивного разворота строки:
    public static String reverseString(String originString) {
        String leftPartLine;
        String rightPartLine;

        if (originString.length() <= 1) {
            return originString;
        }

        leftPartLine = originString.substring(0, originString.length() / 2);
        rightPartLine = originString.substring(originString.length() / 2);
        return reverseString(rightPartLine) + reverseString(leftPartLine);
    }

    //Получение строки из заданных чисел:
    public static StringBuilder numString(int firstNumber, int secondNumber) {
        StringBuilder finalString = new StringBuilder();
        finalString.append(firstNumber);
        String mathSimbol = null;
        int calculation = 0;
        String equally = " = ";
        int randomIndex = new Random().nextInt(3);
        switch (randomIndex) {
            case 0:
                mathSimbol = " + ";
                calculation = firstNumber + secondNumber;
                break;
            case 1:
                mathSimbol = " - ";
                calculation = firstNumber - secondNumber;
                break;
            case 2:
                mathSimbol = " * ";
                calculation = firstNumber * secondNumber;
                break;
        }
        finalString.append(mathSimbol);
        finalString.append(secondNumber);
        finalString.append(equally);
        finalString.append(calculation);

        return finalString;

    }


    //Первый метод замены символа:
    public static StringBuilder replaceSimbol(StringBuilder originString) {
        originString.deleteCharAt(7);
        originString.insert(7, "равно");
        return originString;

    }

    //Второй метод замены символа:
    public static StringBuilder replaceSimbolTwo(StringBuilder originString) {
        originString.replace(7, 8, "равно");
        return originString;

    }

    //Подсчет времени выполнения замены символа в String:
    public static long replaceSimbolString(StringBuilder originString) {
        String newOriginString = originString.toString().repeat(10000);
        long start = System.currentTimeMillis();
        String finalString = newOriginString.replace("=", "равно");
        long finalTime = System.currentTimeMillis() - start;
        return finalTime;

    }

    //Подсчет времени выполнения замены символа в StringBuilder
    public static long replaceSimbolStringBuilder(StringBuilder originString) {
        String newOriginString = originString.toString().repeat(10000);
        StringBuilder finalString = new StringBuilder();
        finalString.append(newOriginString);
        long start = System.currentTimeMillis();
        for (int i = 0; i < finalString.length(); i++) {
            if (finalString.charAt(i) == '=') {
                finalString.replace(i, i + 1, "равно");
            }
        }
        long finalTime = System.currentTimeMillis() - start;
        return finalTime;

    }
    
}