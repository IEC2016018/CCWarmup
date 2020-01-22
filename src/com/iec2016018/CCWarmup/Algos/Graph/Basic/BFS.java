package com.iec2016018.CCWarmup.Algos.Graph.Basic;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFS {

    /*

            B R E A D T H  F I R S T  S E A R C H  --

            ABOUT       :

        >   Similar to Bradth first traversal of a tree
        >   Unlike tree Graphs may contain cycles, sor we may come to the same
            node again

            COMPLEXITY     :   O (V + E)

            VARIATIONS  :



     */
    void bfSearch(LinkedList<Integer>[] graph, int vertex, int vertexCount){
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()){
            vertex = queue.poll();
            Iterator<Integer> i = graph[vertex].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //Date 1 jan 2020
    //------------------------------- bf search with complexity O (V + E)





}
