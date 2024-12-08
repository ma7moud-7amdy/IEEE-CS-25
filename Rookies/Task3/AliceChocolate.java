package com.mycompany.task3;

import java.util.Scanner;

public class AliceChocolate {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int left =0 ;
        int right = n-1;
        int aliceTime=0;
        int bobTime=0;
        while(right > left){
            if(aliceTime < bobTime ){
                aliceTime += arr[left];
                left++;
            }
            else if(bobTime < aliceTime ){
                bobTime += arr[right];
                right--;
            }
            else{
                aliceTime += arr[left];
                bobTime += arr[right];
                left++;
                right--;
            }
        }
        if(left == right ){
             if(bobTime < aliceTime ){
                bobTime += arr[right];
                right--;
            }
            else{
                aliceTime += arr[left];
                left++;
            }
        }
        System.out.println(left + " " + (n-1-right));

    }
}
