package com.iec2016018.CCWarmup.Algos.Graph.Basic;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFS
{
    private int vertexCount;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    BFS(int v)
    {
        vertexCount = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // Driver method to
    public static void main(String args[])
    {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertexCount];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Breadth first search

            >   Similar to Bradth first traversal of a tree
            >   Unlike tree Graphs may contain cycles, sor we may come to the same
                node again

            C O M P L E X I T Y     :   O (V + E)

     */

    void bfSearch_0(int vertex){
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()){
            vertex = queue.poll();
            Iterator<Integer> i = adj[vertex].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //Date 1 jan 2019
    //------------------------------- bf search with complexity O (V + E)

    void bfSearch_1(int vertex) {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            Iterator<Integer> iterator = adj[vertex].listIterator();
            while(iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //--------------------------- bf search with complexity O (V + E)

    void bfSearch_2(int vertex) {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            Iterator<Integer> i = adj[vertex].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }












}
