package com.iec2016018.CCWarmup.Algos.Graph;

import com.iec2016018.CCWarmup.Algos.Source.Graph;

public class UnionFind {

    /*

            D I A L S  S P  --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

     */

    class Subset {
        int parent;
        int rank;

    }
    int find(Subset[] subsets, int i){
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void union(Subset[] subsets, int x, int y){
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot;
        }else if (subsets[yRoot].rank < subsets[xRoot].rank){
            subsets[yRoot].parent = yRoot;
        }else {
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }
    }
    int isCycle(Graph graph){
        int vCount = graph.vCount, eCount = graph.eCount;
        Subset[] subsets = new Subset[vCount];
        for (int i = 0 ; i < vCount ; i++){
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        for (int i = 0 ; i < eCount ; i++){
            int x = find(subsets, graph.edges[i].src);
            int y = find(subsets, graph.edges[i].dest);
            if (x == y){
                return 1;
            }
            union(subsets, x, y);
        }
        return 0;
    }

    // ==========================================================  P R A C T I C edgeCount  H edgeCount R edgeCount ============================

    //Date 23 june
    //---------------------------------












}
