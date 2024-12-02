package com.mycompany.task1;

import java.util.Scanner;

public class LuckyDivision {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean divided = false;
        for (int i = 4; i <= n; i++) {
            if ((n % i == 0) && isLucky(i)) {
                divided = true;
                break;
            }
        }
        if (divided) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static boolean isLucky(int num) {

        while (num > 10) {
            if (num % 10 != 4 && num % 10 != 7) {
                return false;
            }
            num /= 10;
        }
        if (num == 4 || num == 7) {
            return true;
        } else {
            return false;
        }
    }

}

//public static boolean isLucky(int n){
//        if(n ==4 || n ==7){
//            return true;
//        }
//        if(n<3){
//            return false;
//        }
//        if(n%10 !=4 && n%10 !=7){
//            return false;
//        }
//        
//        return isLucky(n/10);
//        
//    }
