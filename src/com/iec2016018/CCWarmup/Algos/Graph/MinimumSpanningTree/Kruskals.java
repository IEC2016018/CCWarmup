package com.iec2016018.CCWarmup.Algos.Graph.MinimumSpanningTree;

import com.iec2016018.CCWarmup.Algos.Source.*;

import java.util.Arrays;

public class Kruskals {

    /*

            K R U S H K A L S  for  M S T  --

            ABOUT       :

        >   This is a greedy algo

            COMPLEXITY  :   O (ElogE) or O(ElogV)

            VARIATIONS  :

     */

    int findRoot(Subset[] subsets, int i){
        if (subsets[i].parent != i){
            subsets[i].parent = findRoot(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void union_0(Subset[] subsets, int x, int y){
        int xRoot = findRoot(subsets, x);
        int yRoot = findRoot(subsets, y);
        if (subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot;
        }else if(subsets[yRoot].rank < subsets[xRoot].rank){
            subsets[yRoot].parent = xRoot;
        }else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }
    void kruskalMST(Edge[] edges, int vertexCount){
        Edge[] result = new Edge[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            result[i] = new Edge();
        }
        Arrays.sort(edges);
        Subset[] subsets = new Subset[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int edgesDone = 0;
        int count = 0;
        while(edgesDone < vertexCount -1){
            Edge nextEdge = edges[count++];
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);
            if ( x != y){
                result[edgesDone++] = nextEdge;
                union_0(subsets, x, y);
            }
        }
        for (int i = 0 ; i < edgesDone ; i++){
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //Date 1 jan 2020
    //------------------------------------























}
