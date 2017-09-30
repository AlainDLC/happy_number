//        A happy number is a number where you can take the sum of the square digits and
//        then repeat on the new sum until you reach 1.
//        The number is not a happy number (unhappy number) if it ends in a never ending loop.
//        Example of a happy number: 31 => 3^2 + 1^2 => 10 => 1^2 + 0^2 = 1
//        Example of an unhappy number: 4 => 16 => 37 => 58 => 89 =>145 => 42 => 20 >= 4
//        You task is to write a program that prints the first happy numbers in natural
//        order found within the range 1 - 1000 to the console,


import java.util.HashSet;

public class App {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            boolean isHappy = isHappyNumber(i);
            if (isHappy) {
                System.out.println(ANSI_BLUE + i + ANSI_RESET + ANSI_GREEN + "  happy number" + ANSI_RESET);
            } else {
                System.out.println(i + ANSI_RED + " unhappy number" + ANSI_RESET);
            }
        }
    }

    public static boolean isHappyNumber(int number) {
        HashSet<Integer> s = new HashSet<>();
        while (!s.contains(number)) {
            s.add(number);
            number = sumOfSquare(number);
            if (number == 1) {
                return true;
            }
        }
        return false;
    }

    public static int sumOfSquare(int num) {
        if (num == 0)
            return 0;
        else {
            int temp = num % 10;
            return (temp * temp + sumOfSquare(num / 10));
        }
    }
}