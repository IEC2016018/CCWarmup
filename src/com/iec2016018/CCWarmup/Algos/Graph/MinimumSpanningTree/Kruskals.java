package com.iec2016018.CCWarmup.Algos.Graph.MinimumSpanningTree;

import java.util.Arrays;

public class Kruskals {

    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        // Comparator function used for sorting edges
        // based on their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };

    // A class to represent a Subset for union-find
    class Subset
    {
        int parent, rank;
    };

    int vertices, edges;    // vertices-> no. of vertices & edges->no.of edges
    Edge edge[]; // collection of all edges

    // Creates a graph with vertexCount vertices and E edges
    Kruskals(int v, int e)
    {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    // Driver Program
    public static void main (String[] args)
    {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Kruskals graph = new Kruskals(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(Subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void union(Subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST()
    {
        Edge result[] = new Edge[vertices];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i< vertices; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating vertexCount ssubsets
        Subset Subsets[] = new Subset[vertices];
        for(i=0; i< vertices; ++i)
            Subsets[i]=new Subset();

        // Create vertexCount Subsets with single elements
        for (int v = 0; v < vertices; ++v)
        {
            Subsets[v].parent = v;
            Subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        // Number of edges to be taken is equal to vertexCount-1
        while (e < vertices - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(Subsets, next_edge.src);
            int y = find(Subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                union(Subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Kruskal's Minimum Spanning Tree

            >   This is a greedy algo

            C O M P L E X I T Y     :   O (ElogE) or O(ElogV)

     */

    int findRoot_0(Subset[] subsets, int i){
        if (subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void union_0(Subset[] subsets, int x, int y){
        int xRoot = findRoot_0(subsets, x);
        int yRoot = findRoot_0(subsets, y);
        if (subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot;
        }else if(subsets[yRoot].rank < subsets[xRoot].rank){
            subsets[yRoot].parent = xRoot;
        }else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }
    void kruskalMST(){
        Edge[] result = new Edge[vertices];
        for (int i = 0; i < vertices; i++){
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        Subset[] subsets = new Subset[vertices];
        for (int i = 0; i < vertices; i++){
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int edgesDone = 0;
        int count = 0;
        while(edgesDone < vertices -1){
            Edge nextEdge = edge[count++];
            int x = findRoot_0(subsets, nextEdge.src);
            int y = findRoot_0(subsets, nextEdge.dest);
            if ( x != y){
                result[edgesDone++] = nextEdge;
                union_0(subsets, x, y);
            }
        }
        for (int i = 0 ; i < edgesDone ; i++){
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }

    //Date 2 jan 2020
    //------------------------------------

    int findRoot_1(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = findRoot_1(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void union_1(Subset[] subsets, int x, int y) {
        int xRoot = findRoot_1(subsets, x);
        int yRoot = findRoot_1(subsets, y);
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        }else if (subsets[yRoot].rank < subsets[xRoot].rank) {
            subsets[yRoot].parent = xRoot;
        }else {
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }
    }
    void krushkalMST() {
        Edge[] result = new Edge[vertices];
        for (int i = 0 ; i < vertices ; i++) result[i] = new Edge();
        Arrays.sort(edge);
        Subset[] subsets = new Subset[vertices];
        for (int i = 0 ; i < vertices ; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int edgesDone = 0;
        int count = 0;
        while (edgesDone < vertices - 1) {
            Edge nextEdge = edge[count++];
            int x = findRoot_1(subsets, nextEdge.src);
            int y = findRoot_1(subsets, nextEdge.dest);
            if (x != y) {
                result[edgesDone++] = nextEdge;
                union_1(subsets, x, y);
            }
        }
    }
























}
