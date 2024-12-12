package com.mycompany.task4;

import java.util.*;

public class KnightMoves {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for (int i = 0; i < T; i++) {
            String info = input.nextLine().toLowerCase();
            String[] positions = info.split(" ");
            String start = positions[0];
            String end = positions[1];

            System.out.println(minMoves(start, end));
        }

    }

    private static int minMoves(String start, String end) {
        int[][] knightMoves = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

        if (start.equals(end)) {
            return 0;
        }
        int startX = start.charAt(0) - 'a';
        int startY = start.charAt(1) - '1';
        int endX = end.charAt(0) - 'a';
        int endY = end.charAt(1) - '1';

        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            for (int[] move : knightMoves) {
                int newX = x + move[0];
                int newY = y + move[1];

                if (newX == endX && newY == endY) {
                    return steps + 1;
                }

                if (isValid(newX, newY) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, steps + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            return true;
        } else {
            return false;
        }
    }
}
