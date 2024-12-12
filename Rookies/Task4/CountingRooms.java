
package com.mycompany.task4;

import java.util.*;

public class CountingRooms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = input.nextLine().toCharArray();
        }

        int num = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.' && !visited[i][j]) {
                    bfs(map, visited, i, j, n, m);
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    private static void bfs(char[][] map, boolean[][] visited, int startX, int startY, int n, int m) {
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY, n, m, map, visited)) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

    private static boolean isValid(int x, int y, int n, int m, char[][] map, boolean[][] visited) {
        if(x >= 0 && x < n && y >= 0 && y < m && map[x][y] == '.' && !visited[x][y]){
            return true;
        }
        return false;
    }
}