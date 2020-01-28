package com.iec2016018.CCWarmup.Algos.Graph;

import java.util.ArrayList;

public class Fleurys {

    /*

            F L E U R Y S  A L G O --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */
    private int vertices; // No. of vertices
    private ArrayList<Integer>[] adj; // adjacency list
    private void addEdge(Integer u, Integer v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    private void removeEdge(Integer u, Integer v) {
        adj[u].remove(v);
        adj[v].remove(u);
    }
    private void printEulerTour(){
        Integer u = 0;
        for (int i = 0 ; i < vertices ; i++){
            if (adj[i].size() % 2 == 1){
                u = i;
                break;
            }
        }
    }
    private void printEulerUtil(Integer u){
        for (int i = 0 ; i < adj[u].size() ; i++){
            Integer v = adj[u].get(i);
            if (isValidNextEdge(u, v)){
                System.out.print(u + "-" + v + " ");
                removeEdge(u, v);
                printEulerUtil(v);
            }
        }
    }
    private boolean isValidNextEdge(Integer u, Integer v){
        if (adj[u].size() == 1){
            return true;
        }
        boolean[] isVisited = new boolean[vertices];
        int count = dfsCount(u, isVisited);
        removeEdge(u, v);
        isVisited = new boolean[vertices];
        int count1 = dfsCount(u, isVisited);
        addEdge(u, v);
        return count <= count1;
    }

    private int dfsCount(Integer v, boolean[] isVisited){
        isVisited[v] = true;
        int count = 1;
        for (int adj: adj[v]){
            if (!isVisited[adj]){
                count = count + dfsCount(adj, isVisited);
            }
        }
        return count;
    }


    // ==========================================================  P R A C T I C E  H E R E ============================


    // ----------------------

}
