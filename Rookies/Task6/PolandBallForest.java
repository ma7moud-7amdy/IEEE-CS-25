
package com.mycompany.task6;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class PolandBallForest {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n + 1];

        graph = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (int i = 1; i <= n; i++) {
            p[i] = in.nextInt();
            if (p[i] != i) { 
                graph[i].add(p[i]);
                graph[p[i]].add(i);
            }
        }

        int treeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                treeCount++;
                DFS(i);
            }
        }

        System.out.println(treeCount);
    }

    // DFS traversal
    private static void DFS(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                for (int neighbor : graph[curr]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}

