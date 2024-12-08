
package com.mycompany.task3;

import java.util.Scanner;

import java.util.Scanner;

public class Books {

    public static void main(String[] args) {
        // input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int freeTime = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        // sliding window
        int curr =0;
        int best = 0;
        int left = -1;
        for (int right = 0; right < n; right++) {
            curr += arr[right];
            while (curr > freeTime) {
                left++;
                curr -= arr[left];
            }
            best = Math.max(best, right - left);
        }
        System.out.println(best);
    }
}
