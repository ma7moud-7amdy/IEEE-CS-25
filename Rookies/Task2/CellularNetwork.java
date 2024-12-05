package com.mycompany.task2;

import java.util.Arrays;
import java.util.Scanner;

public class CellularNetwork {

    public static void main(String[] args) {
        // input
        Scanner input = new Scanner(System.in);
        int numCities = input.nextInt();
        int numTowers = input.nextInt();

        int[] cities = new int[numCities];
        for (int i = 0; i < numCities; i++) {
            cities[i] = input.nextInt();
        }

        int[] towers = new int[numTowers];
        for (int i = 0; i < numTowers; i++) {
            towers[i] = input.nextInt();
        }

        // prosessing
        int min = 0;
        int distance;
        for (int i = 0; i < numCities; i++) {
            distance = findMinDistance(cities[i], towers);

            if (distance > min) {
                min = distance;
            }
        }

        System.out.println(min);

    }

    public static int findMinDistance(int city, int[] towers) {
        int L = 0;
        int R = towers.length - 1;
        int M = (L + R) / 2;

        // binary search
        while (L <= R) {
            M = (L + R) / 2;
            if (city < towers[M]) {
                R = M - 1;
            } else if (city > towers[M]) {
                L = M + 1;
            } else {
                return 0;
            }
        }
        // if not found return previous index

        if (L == 0) {
            return towers[0] - city;
        } else if (L == towers.length) {
            return city - towers[L - 1];
        } else {
            return Math.min(city - towers[L - 1], towers[L] - city);
        }

    }

}
