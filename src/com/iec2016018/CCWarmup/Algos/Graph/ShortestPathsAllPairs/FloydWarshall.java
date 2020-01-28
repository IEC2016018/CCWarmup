package com.iec2016018.CCWarmup.Algos.Graph.ShortestPathsAllPairs;

public class FloydWarshall {

    final static int INF = 99999, vertexCount = 4;
    /*
            F L O Y D  W A R S H A L L  S P A P  --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    void floydWarshall(int[][] graph){
        int[][] dist = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                dist[i][j] = graph[i][j];
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                for (int k = 0; k < vertexCount; k++) {
                    if (dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
//        printSolution(dist);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //---------------------------------










}
