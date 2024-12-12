package com.mycompany.task4;

import java.util.*;

public class Labyrinth {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final char[] MOVES = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        char[][] map = new char[n][m];
        int startX = -1;
        int startY = -1;
        int endX = -1 ;
        int endY = -1;
        
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            map[i] = line.toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }
        Data result = bfs(map, n, m, startX, startY, endX, endY);

        if (result.found) {
            System.out.println("YES");
            System.out.println(result.length);
            System.out.println(result.path);
        } else {
            System.out.println("NO");
        }
    }

    static Data bfs(char[][] map, int n, int m, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] previous = new int[n][m];

        for (int[] row : previous) {
            Arrays.fill(row, -1);
        }

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i< 4; i++) {
                int newX = x + DIRECTIONS[i][0];
                int newY = y + DIRECTIONS[i][1];

                if (newX == endX && newY == endY) {
                    previous[newX][newY] = i;
                    return getpath(previous, startX, startY, endX, endY);
                }

                if (isValid(newX, newY, n, m, map, visited)) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                    previous[newX][newY] = i;
                }
            }
        }

        return new Data(false, 0, "");
    }

    static boolean isValid(int x, int y, int n, int m, char[][] map, boolean[][] visited) {
        return x >= 0 && x < n && y >= 0 && y < m && map[x][y] != '#' && !visited[x][y];
    }

    static Data getpath(int[][] previous, int startX, int startY, int endX, int endY) {
        StringBuilder path = new StringBuilder();
        int x = endX;
        int y = endY;
        int length = 0;

        while (!(x == startX && y == startY)) {
            int direction = previous[x][y];
            path.append(MOVES[direction]);
            x -= DIRECTIONS[direction][0];
            y -= DIRECTIONS[direction][1];
            length++;
        }

        path.reverse();
        return new Data(true, length, path.toString());
    }

    static class Data {
        boolean found;
        int length;
        String path;
        
        Data(boolean found, int length, String path) {
            this.found = found;
            this.length = length;
            this.path = path;
        }
    }
}
