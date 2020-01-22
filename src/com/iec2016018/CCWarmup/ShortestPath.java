package com.iec2016018.CCWarmup;

public class ShortestPath {

    static final int V = 4;
    static final int INFINITE = Integer.MAX_VALUE;

    int shortestPath(int[][] graph, int u, int v, int k){

        int sp[][][] = new int[V][V][k+1];

        for (int e = 0 ; e <= k ;e++){
            for (int i = 0 ; i < V ; i++){
                for (int j = 0 ; j < V ; j++){
                    sp[i][j][e] = INFINITE;
                    if (e == 0 && i == j){
                        sp[i][j][e] = 0;
                    }
                    if (e == 1 && graph[i][j] != INFINITE){
                        sp[i][j][e] = graph[i][j];
                    }
                    if (e > i){
                        for (int a = 0 ; a < V ; a++){
                            if (graph[i][a] != INFINITE && i != a &&
                            j != a && sp[a][j][e-1] != INFINITE){
                                sp[i][j][e] = Math.min(sp[i][j][e],
                                        graph[i][a] + sp[a][j][e-1]);
                            }
                        }
                    }
                }
            }
        }
        return sp[u][v][k];
    }


}
