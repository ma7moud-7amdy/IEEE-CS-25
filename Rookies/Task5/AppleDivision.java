package com.mycompany.task5;

import java.util.*;

public class AppleDivision {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        long min = minDif(arr, n, 0, 0);

        System.out.println(min);
    }

    public static long minDif(int[] arr, int remainingWeights, long group1Sum, long group2Sum) {
        if (remainingWeights == 0) {
            return Math.abs(group2Sum - group1Sum);
        }

        long increaseGroup1 = minDif(arr, remainingWeights - 1, group1Sum + arr[remainingWeights - 1], group2Sum);
        long increaseGroup2 = minDif(arr, remainingWeights - 1, group1Sum, group2Sum + arr[remainingWeights - 1]);

        return Math.min(increaseGroup1, increaseGroup2);
    }
}
