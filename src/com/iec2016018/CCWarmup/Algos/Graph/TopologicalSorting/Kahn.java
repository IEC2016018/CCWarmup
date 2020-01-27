package com.iec2016018.CCWarmup.Algos.Graph.TopologicalSorting;

import java.util.*;

public class Kahn {

    /*

            K A H N  T S  --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

     */

    int vCount;// No. of vertices
    List<Integer> adj[];

    void kahnSort() {
        int[] indegree = new int[vCount];
        for (int i = 0; i < vCount; i++) {
            for (int n: adj[i]) {
                indegree[n]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < vCount; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        ArrayList<Integer> topOrder = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topOrder.add(u);
            for (int node: adj[u]) {
                if (--indegree[node] == 0) queue.add(node);
            }
            count++;
        }
        if (count != vCount) System.out.println("Graph contains cycle");
    }


    // ==========================================================  P R A C T I C E  H E R E ============================








}
