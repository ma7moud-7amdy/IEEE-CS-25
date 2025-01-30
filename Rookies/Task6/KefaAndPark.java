package com.mycompany.task6;

import java.util.LinkedList;
import java.util.Scanner;

public class KefaAndPark {

    static LinkedList<Integer>[] neighbours;
    static int[] hasCat;
    static long numOfRest = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        hasCat = new int[n + 1];
        neighbours = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            hasCat[i] = in.nextInt();
            neighbours[i] = new LinkedList();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            neighbours[u].add(v);
            neighbours[v].add(u);
        }

        DFS(1, m, hasCat[1], -1);
        System.out.println(numOfRest);
    }

    public static void DFS(int v, int maxCats, int nOfCats, int parent) {
        if (nOfCats > maxCats) {
            return;
        }

        boolean isLeaf = true;

        for (int u : neighbours[v]) {
            if (u != parent) {
                isLeaf = false;
                DFS(u, maxCats, (hasCat[u] == 1 ? nOfCats + 1 : 0), v);
            }
        }

        if (isLeaf && v != 1) {
            numOfRest++;
        }
    }
}
