package com.iec2016018.CCWarmup.Algos.Graph.Basic;
// Java program to print DFS traversal from a given given graph
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class DFS
{
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }

    public static void main(String args[])
    {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }

    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Depth first search

            >   Similar to Depth first traversal of a tree
            >   Unlike tree Graphs may contain cycles, sor we may come to the same
                node again

            C O M P L E X I T Y     :   O (V + E)

     */

    void dfSearchUtil_0(int vertex, boolean[] visited){
        visited[vertex] = true;
        Iterator<Integer> iterator = adj[vertex].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if (!visited[n]) dfSearchUtil_0(n, visited);
        }
    }

    void dfSearch_0(int vertexCount){
        boolean[] visited = new boolean[vertexCount];
        dfSearchUtil_0(vertexCount, visited);
    }

    //Date 1 jan
    //------------------------------------- df search with complexity V+E

    void dfSearchUtil_1(boolean[] visited, int vertex) {
        visited[vertex] = true;
        Iterator<Integer> iterator = adj[vertex].listIterator();
        while(iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) dfSearchUtil_1(visited, n);
        }
    }

    void dfSearch_1(int vertexCount) {
        boolean[] visited = new boolean[vertexCount];
        dfSearchUtil_1(visited, vertexCount);
    }

    //------------------------- df search with complexity V+E

    void dfSearchUtil_2(boolean[] visited, int vertex) {
        visited[vertex] = true;
        Iterator<Integer> iterator = adj[vertex].listIterator();
        while(iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[vertex]) dfSearchUtil_2(visited, n);
        }
    }

    void dfSearch_2(int vertex) {
        boolean[] visited = new boolean[vertex];
        dfSearchUtil_2(visited, vertex);
    }


















}
