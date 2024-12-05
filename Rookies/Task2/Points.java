package com.mycompany.task2;
import java.util.*;

public class Points {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int d = input.nextInt();
        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = input.nextInt();
        }

        long count = 0;
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            while (j < n && points[j] - points[i] <= d) {
                j++;
            }
            
            int numOfPoints = j - i - 1;
            if (numOfPoints >= 2) {
                count += (long) numOfPoints * (numOfPoints - 1) / 2;
            }
        }
        System.out.println(count);
    }
}
