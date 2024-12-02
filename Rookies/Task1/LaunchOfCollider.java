package com.mycompany.task1;

import java.util.Scanner;

public class LaunchOfCollider {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char[] direction = input.next().toCharArray();
        int[] postions = new int[n];
        for (int i = 0; i < n; i++) {
            postions[i] = input.nextInt();
        }
        // find first 
        int firstPosition = isCollision(direction);

        if (firstPosition < 0) {
            System.out.println(-1);
        } else {
            int min;
            min = postions[firstPosition] - postions[firstPosition - 1];
            int cDistance;
            for (int i = firstPosition + 1; i < n; i++) {
                if (direction[i] == 'L' && direction[i - 1] == 'R') {
                    cDistance = postions[i] - postions[i - 1];
                    if (cDistance < min) {
                        min = cDistance;
                    }
                }
            }
            System.out.println(min / 2);
        }

    }

    public static int isCollision(char[] arr) {
        boolean right = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') {
                right = true;
            } else if (arr[i] == 'L' && right) {
                return i;
            }
        }
        return -1;
    }
}
