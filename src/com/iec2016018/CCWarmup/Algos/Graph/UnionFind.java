package com.iec2016018.CCWarmup.Algos.Graph;

public class UnionFind {

    static int vertexCount, edgeCount;
    Edge[] edge;

    UnionFind(int nV, int nE)
    {
        vertexCount = nV;
        edgeCount = nE;
        edge = new Edge[edgeCount];
        for (int i = 0; i < edgeCount; i++)
        {
            edge[i] = new Edge();
        }
    }

    // class to represent edge
    class Edge
    {
        int src, dest;
    }

    // class to represent Subset
    class Subset
    {
        int parent;
        int rank;
    }

    // Driver Code
    public static void main(String [] args)
    {
/* Let us create the following graph
    0
    | \
    | \
    1-----2 */

        int V = 3, E = 3;
        UnionFind graph = new UnionFind(V, E);

// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

// add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

// add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph) == 1)
            System.out.println("BellmanFord contains cycle");
        else
            System.out.println("BellmanFord doesn't contain cycle");
    }

    // A utility function to find
// set of an element i (uses
// path compression technique)
    int find(Subset[] subsets , int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets,
                    subsets[i].parent);
        return subsets[i].parent;
    }

    // A function that does union
// of two sets of x and y
// (uses union by rank)
    void Union(Subset[] subsets,
               int x , int y )
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[yroot].rank < subsets[xroot].rank)
            subsets[yroot].parent = xroot;
        else
        {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }

    // The main function to check whether
// a given graph contains cycle or not
    int isCycle(UnionFind graph)
    {
        int V = graph.vertexCount;
        int E = graph.edgeCount;

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++)
        {

            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        for (int e = 0; e < E; e++)
        {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if(x == y)
                return 1;
            Union(subsets, x, y);
        }
        return 0;
    }

    // ==========================================================  P R A C T I C edgeCount  H edgeCount R edgeCount ============================

    int find_0(Subset[] subsets, int i){
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union_0(Subset[] subsets, int x, int y){
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

    int isCycle_0(UnionFind graph){
        Subset[] subsets = new Subset[vertexCount];
        for (int i = 0 ; i < vertexCount ; i++){
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        for (int i = 0 ; i < edgeCount ; i++){
            int x = find(subsets, graph.edge[i].src);
            int y = find(subsets, graph.edge[i].dest);
            if (x == y){
                return 1;
            }
            Union(subsets, x, y);
        }
        return 0;
    }

    //Date 23 june
    //---------------------------------












}
