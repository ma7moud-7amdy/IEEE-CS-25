package com.mycompany.task2;

import java.util.Scanner;

public class Books {

    public static void main(String[] args) {
        // input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int freeTime = input.nextInt();

        int[] booksTime = new int[n];
        for (int i = 0; i < n; i++) {
            booksTime[i] = input.nextInt();
        }
        //processing
        int max = 0;
        for (int i = 0; i < n; i++) {
            int time = freeTime;
            int num = 0;
            int j = i;
            while (time > 0 && j < n) {
                if (time >= booksTime[j]) {
                    num++;
                    time = time - booksTime[j];
                }
                j++;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }
}
