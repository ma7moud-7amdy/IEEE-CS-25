
package com.mycompany.task5;

    
import java.util.*;

public class WeirdAlgorithm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        String result = findSequence(n);
            System.out.println(result);

    }

    public static String findSequence(long n) {
        // Base case: if n is 1, return "1"
        if (n == 1) {
            return "1";
        }
        // Recursion
        if (n % 2 == 0) {
            return n + " " + findSequence(n / 2);
        } else {
            return n + " " + findSequence(3 * n + 1);
        }
    }
}

