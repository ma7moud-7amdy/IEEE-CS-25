package com.mycompany.task6;

import java.util.LinkedList;
import java.util.Scanner;

public class SendTheFoolFurther {
    
    static LinkedList<Path>[]neighbours;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // adjList to store graph
        neighbours = new LinkedList[n];
        visited = new boolean [n];
        for(int i=0 ; i< n ;i++){
            neighbours[i]=new LinkedList();
        }
        
        int u,v,c;
        for(int i=0 ; i< n-1 ;i++){
            u = in.nextInt();
            v = in.nextInt();
            c = in.nextInt();
            neighbours[u].add(new Path(v,c));
            neighbours[v].add(new Path(u,c));
        }
        int maxCost = DFS(0);
        System.out.println(maxCost);

    }
    
    public static int DFS (int v){
        visited[v]=true;
        int numOfNeighbours = neighbours[v].size();
        int [] costs = new int[numOfNeighbours];
        for(int i=0 ; i<numOfNeighbours ; i++ ){
            Path curr = neighbours[v].get(i);
            if(!visited[curr.nextFriend]){
                costs[i]= curr.cost + DFS(curr.nextFriend);
            }
        }
        // find Maximum cost
        int max=costs[0];
        for(int i=1 ; i<numOfNeighbours ; i++){
            if(costs[i] > max)
                max=costs[i];
        }
        return max;
    }

}

class Path {

    int nextFriend;
    int cost;

    public Path(int nextFriend, int cost) {
        this.nextFriend = nextFriend;
        this.cost = cost;
    }

}
