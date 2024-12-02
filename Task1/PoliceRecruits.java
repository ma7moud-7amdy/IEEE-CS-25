package com.mycompany.task1;
import java.util.Scanner;
public class PoliceRecruits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int officers=0;
        int untreated=0;
        for (int i = 0; i < n; i++) {
            if(officers == 0 && arr[i] == -1 ){
                untreated++;
            }
            else{
                officers+=arr[i];
            }
        }
        System.out.println(untreated);
    }
}

