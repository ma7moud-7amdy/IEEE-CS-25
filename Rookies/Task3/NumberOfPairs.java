package com.mycompany.task3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfPairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int out = 0 ; out< t ; out++ ) {
            int n = input.nextInt();
            int l = input.nextInt(); 
            int r = input.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            Arrays.sort(arr);
            long count = 0;
            for (int i = 0; i < n; i++) {
                int low = getLowerBound(arr, i + 1, n, l - arr[i]);
                int high = getLowerBound(arr, i + 1, n, r - arr[i] + 1);

                count += high - low;
            }
            System.out.println(count);
        }
    }

    public static int getLowerBound(int[] arr, int L, int R, int value) {
        
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] < value) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return L;
    }
}
