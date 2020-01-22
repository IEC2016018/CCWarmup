package com.iec2016018.CCWarmup;

import java.util.*;

public class Graph {

    // Kruskal's algo

    // A class to represent a graph edge
    class Edge implements Comparable<Edge>{
        int src, dest, weight;

        // Comparator function used for sorting edges
        // beased on their weight
        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight;
        }
    }

    // A class to represent a subset for union find
    class Subset{
        int parent, rank;
    }

    int V, E;
    Edge[] edges; // collection of all edges

    // Creates a graph with V vertices and E edges
    Graph(int v, int e){
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0 ; i < e ; ++i){
            edges[i] = new Edge();
        }
    }

    // A utility function to find set of an element i
    // (uses path compression technique
    int find(Subset[] subsets, int i){
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // A function that does unio of two sets of x and y
    // (uses union by rank);
    void Union(Subset[] subsets, int x, int y){
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        // Attach smaller rank tree under root of higher rank tree
        // (Union by Rank)
        if (subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot;
        }else if (subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot;
        }

        // If ranks are same, then make one as root and increment
        // its rank by one
        else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }

    }

    // the main function to construct MST using kruskal's algorithm
    Edge[] kruskalMST2(){
        Edge[] result = new Edge[V];
        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int i = 0 ; i < V ; i++){
            subsets[i] = new Subset();
        }
        for (int i = 0 ;  i < V ; i++){
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        int edgePointer = 0;
        int edgesDone = 0;
        while(edgesDone < V-1){
            Edge nextEdge = edges[edgePointer++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if (x != y){
                result[edgesDone++] = nextEdge;
                Union(subsets, x, y);
            }
        }
        return result;
    }


















}














