import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String errorMsg = "\nPlease check your input\nThe input should be: 2 or 3 numbers that's in the range of 1-10";
        DecimalFormat myDF = new DecimalFormat("0.#");

        Scanner sc = new Scanner(System.in);
        System.out.print("Input calculation: ");

        char[] input = sc.nextLine().replaceAll(" ", "").toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (i % 2 != 0 && Character.isDigit(input[i])) {
                throw new UnsupportedOperationException(errorMsg);
            }
        }

        double first2 = doMath(Character.getNumericValue(input[0]), String.valueOf(input[1]), Character.getNumericValue(input[2]));
        if (input.length == 3) {
            System.out.println(myDF.format(first2));
            System.exit(0);
        } else if (input.length == 5) {
            if (input[3] == '*' || input[3] == '/') {
                double temp = doMath(Character.getNumericValue(input[2]), String.valueOf(input[3]), Character.getNumericValue(input[4]));
                System.out.println(myDF.format(doMath(Character.getNumericValue(input[0]), String.valueOf(input[1]), temp)));
            } else {
                System.out.println(myDF.format(doMath(first2, String.valueOf(input[3]), Character.getNumericValue(input[4]))));
            }
        } else {
            throw new UnsupportedOperationException(errorMsg);
        }
    }

    private static double doMath(double numberOne, String operator, double numberTwo) {
        switch (operator) {
            case "+" -> {
                return numberOne + numberTwo;
            }
            case "-" -> {
                return numberOne - numberTwo;
            }
            case "*" -> {
                return numberOne * numberTwo;
            }
            case "/" -> {
                return numberOne / numberTwo;
            }
        }
        return -1;
    }
}