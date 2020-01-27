package com.iec2016018.CCWarmup.Algos.Graph.ShortestPaths;

public class Dijkstras {

    /*

            D I J K S T R A S  S P  --

            ABOUT       :

        >   Doesn't work for graphs with negative edges


            COMPLEXITY  :    O(VLogV) (with the use of Fibonacci heap)

            VARIATIONS  :

     */

    int minDistance(int[] dist, boolean[] shortestPaths, int vCount){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < vCount; i++){
            if (!shortestPaths[i] && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    void dijkstra(int[][] graph, int vCount, int eCount, int src){
        int[] dist = new int[vCount];
        boolean[] shortestPaths = new boolean[vCount];
        for (int i = 0; i < vCount; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 0; i < vCount -1 ; i++){
            int u = minDistance(dist, shortestPaths, vCount);
            shortestPaths[u] = true;
            for (int v = 0; v < vCount; v++){
                if (!shortestPaths[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        //printSolution(dist, vCount);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================



    //Date 25 june
    // ---------------------------------

















}
