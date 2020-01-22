package com.iec2016018.CCWarmup.Algos.Graph.Basic;
// Java program to print DFS traversal from a given given graph
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class DFS {

    /*

            D E P T H  F I R S T  S E A R C H  --

            ABOUT       :

        >   Similar to Depth first traversal of a tree
        >   Unlike tree Graphs may contain cycles, sor we may come to the same
            node again

            COMPLEXITY     :   O (V + E)

            VARIATIONS  :

     */
    void dfSearchUtil(LinkedList<Integer>[] graph, int vertex, boolean[] visited){
        visited[vertex] = true;
        Iterator<Integer> iterator = graph[vertex].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if (!visited[n]) dfSearchUtil(graph, n, visited);
        }
    }
    void dfSearch(LinkedList<Integer>[] graph, int vertexCount){
        boolean[] visited = new boolean[vertexCount];
        dfSearchUtil(graph, vertexCount, visited);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    //Date 1 jan 2020
    //------------------------------------- df search with complexity V+E





}
