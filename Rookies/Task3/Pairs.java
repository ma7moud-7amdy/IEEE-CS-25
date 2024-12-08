package com.mycompany.task3;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(getPairs(arr, k));
    }

    public static int getPairs(int[] arr, int diff) {
        Arrays.sort(arr);
        int numOfPairs = 0;

        for (int i = 0; i < arr.length; i++) { // O(n)
            int L = i + 1;
            int R = arr.length - 1;

            while (L <= R) { // O(Log(n))
                int M = (L + R) / 2;
                int curDiff = arr[M] - arr[i];

                if (curDiff > diff) {
                    R = M - 1;
                } else if (curDiff < diff) {
                    L = M + 1;
                } else {
                    numOfPairs++;
                    break;
                }
            }
        }
        return numOfPairs;
    }
}
