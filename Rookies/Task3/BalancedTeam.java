
package com.mycompany.task3;

import java.util.Arrays;
import java.util.Scanner;


public class BalancedTeam {
    public static void main(String[] args) {
        // input
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        int left =0 ;
        int best =0;
        for(int right = 0 ; right < n ; right++){
            while(arr[right] - arr[left] > 5){
                left++;
            }
            best = Math.max( best, right - left+1);
        }
        System.out.println(best);
    }
    
}
