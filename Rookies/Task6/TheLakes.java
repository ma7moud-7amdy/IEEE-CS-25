package com.mycompany.task6;

import java.util.Scanner;
import java.util.Stack;

public class TheLakes {

    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    // Directions for moving in 4 possible ways (Right, Left, Down, Up)
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 

        for (int c = 0; c < t; c++) {
            n = in.nextInt();
            m = in.nextInt();
            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            long maxVolume = 0;

            // Find the largest lake volume
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && arr[i][j] > 0) {
                        long currVol = DFS(i, j);
                        maxVolume = Math.max(maxVolume, currVol);
                    }
                }
            }

            System.out.println(maxVolume);
        }
    }

    public static long DFS(int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        long volume = 0;
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0];
            int c = cell[1];
            if (!visited[r][c]) {
                visited[r][c] = true;
                volume += arr[r][c];
            }

            // Explore 4 directions
            for (int d = 0; d < 4; d++) {
                int newRow = r + dx[d];
                int newCol = c + dy[d];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && arr[newRow][newCol] > 0) {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
        return volume;
    }
}

//----------------- solution using recursion-------------------//

//package com.mycompany.task6;
//import java.util.Scanner;
//
//public class TheLakes {
//    static boolean[][] visited ;
//    static long currVol;
//    static int n,m;
//    
//    public static void main (String[] args){
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        
//        for(int test = 0 ; test < t ; test++){
//            
//            n = in.nextInt();
//            m = in.nextInt();
//            int[][] arr = new int [n][m];
//            visited = new boolean[n][m];
//            for(int i=0 ; i< n ; i++ ){
//                for(int j= 0 ; j<m ; j++){
//                    arr[i][j] = in.nextInt();
//                }
//            }
//            
//            long maxVolume =0;
//            for(int i=0 ; i< n ; i++ ){
//                for(int j= 0 ; j<m ; j++){
//                    if(!visited[i][j] && arr[i][j]>0){
//                        currVol =0;
//                        currVol = DFS(arr,i,j);
//                        maxVolume=Math.max(maxVolume, currVol);
//                    }
//                    
//                }
//                
//            }
//            System.out.println(maxVolume);
//        }
//    }
//    
//    public static long DFS (int[][] arr , int row , int col){
//        
//        if ( row<0 || col<0 || row >=n || col >=m || visited[row][col] || arr[row][col]==0 ){
//            return 0;
//        }
//        visited[row][col]= true;
//        currVol+= arr[row][col];
//        //go right
//            DFS(arr,row,col+1);
//        // go left
//            DFS(arr,row,col-1);
//        // go up
//            DFS(arr,row+1,col);
//        // go down
//            DFS(arr,row-1,col);
//        
//        return currVol;
//    }
//}
