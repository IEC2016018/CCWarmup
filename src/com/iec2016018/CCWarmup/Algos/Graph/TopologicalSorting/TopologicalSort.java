package com.iec2016018.CCWarmup.Algos.Graph.TopologicalSorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    /*

            T O P O L O G I C A L  S O R T  --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    private int vertexCount;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    void topologicalSortUtil(int v, boolean[] visited, LinkedList<Integer> topOrder){
        visited[v] = true;
        for (int node : adj[v]) {
            if (!visited[node]) topologicalSortUtil(node, visited, topOrder);
        }
        topOrder.add(v);
    }
    void topologicalSort(){
        LinkedList<Integer> topOrder = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            if (!visited[i]) topologicalSortUtil(i, visited, topOrder);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================



    //---------------------------------










}
