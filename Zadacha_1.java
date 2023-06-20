// Умножьте два числа и верните произведение в виде связанного списка.

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Zadacha_1
 */
public class Zadacha_1 {

     public static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> result = new ArrayDeque<>();
        boolean isNegative = (num1.getLast() < 0) ^ (num2.getLast() < 0);
        num1.removeLast();
        num2.removeLast();
        int[] intermediateResults = new int[num1.size() + num2.size()];
        for (int i = 0; i < num1.size(); i++) {
            int digit1 = num1.removeFirst();
            int carry = 0;

            for (int j = 0; j < num2.size(); j++) {
                int digit2 = num2.removeFirst();
                int product = digit1 * digit2 + intermediateResults[i + j] + carry;

                intermediateResults[i + j] = product % 10;
                carry = product / 10;
                num2.addLast(digit2);
            }

            if (carry > 0) {
                intermediateResults[i + num2.size()] += carry;
            }

            num1.addLast(digit1);
        }

        int i = intermediateResults.length - 1;
        while (i >= 0 && intermediateResults[i] == 0) {
            i--;
        }

        if (isNegative) {
            result.addLast(-1);
        }

        while (i >= 0) {
            result.addLast(intermediateResults[i]);
            i--;
        }

        return result;
    }

}