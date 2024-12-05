package com.mycompany.task2;

import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {

    public static void main(String[] args) {
        // input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = input.nextInt();
        }
        Arrays.sort(prices);
        int q = input.nextInt();
        int[] dayPrices = new int[q];
        for (int i = 0; i < q; i++) {
            dayPrices[i] = input.nextInt();
        }
        // check each day 

        for (int i = 0; i < q; i++) {
            int dayPrice = dayPrices[i];
            int L = 0;
            int R = n - 1;
            int M;

            // binary search
            while (L <= R) {
                M = L + (R - L) / 2;
                if (prices[M] <= dayPrice) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
            System.out.println(L);
        }
    }
}
