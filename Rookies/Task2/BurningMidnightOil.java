package com.mycompany.task2;
import java.util.Scanner;

public class BurningMidnightOil {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        System.out.println(getMinimumV(n, k));
    }
    public static int getMinimumV(int n, int k){
        // Minimum value for v is 1 and maximum is n.
        int left = 1, right = n;
        int minV = n;

        while (left <= right) { // Testing all possible V values
            int mid = (left + right) / 2;
            int tempN = getNforV(mid, k);

            if (tempN >= n) { // >= Because we want min
                right = mid - 1;
                minV = mid;
            }
            else
                left = mid + 1;
        }
        return minV;
    }
    public static int getNforV(int v, int k){
        int n = 0;
        int counter = 0;

        while (true){
            int term = v/(int)Math.pow(k, counter);
            if ( term != 0)
                n += term;
            else // term == 0
                break;
            counter++;
        }
        return n;
    }
}