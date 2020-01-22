package com.iec2016018.CCWarmup.Algos.Graph.StronglyConndComps;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Kosaraju {

    private int vertexCount;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    Kosaraju(int v)
    {
        vertexCount = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)  { adj[v].add(w); }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Kosaraju g = new Kosaraju(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.printSCCs();
    }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    Kosaraju getTranspose()
    {
        Kosaraju g = new Kosaraju(vertexCount);
        for (int v = 0; v < vertexCount; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack)
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // The main function that finds and prints all strongly
    // connected components
    void printSCCs()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[vertexCount];
        for(int i = 0; i < vertexCount; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < vertexCount; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        // Create a reversed graph
        Kosaraju gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while (stack.empty() == false)
        {
            // Pop a vertex from stack
            int v = (int)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[v] == false)
            {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }


    // ==========================================================  P R A C T I C E  H E R E ============================

    // Kosaraju's algorithm for strogly connected components

    /*

            A L G O

        1:  Create an empty stack 'S' and do DFS traversal of a graph.
            In DFS traversal, after calling recursive DFS for adjacent
            vertices of a vertex, push the vertex to stack.
        2:  Reverse directions of all arcs to obtain the transpose graph
        3:  One by one pop a vertex from S while S is not empty. Let the
            popped vertex be 'v'. Take v as source and do DFS
            (call DFSUtil(v)). The DFS starting from v prints strongle
            connected component of v.

     */

    void dfSearchUtil_0(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");
        int n;
        Iterator<Integer> iterator = adj[v].iterator();
        while(iterator.hasNext()){
            n = iterator.next();
            if (!visited[n]){
                dfSearchUtil_0(n, visited);
            }
        }
    }
    Kosaraju getTranspjose_0(){
        Kosaraju graph = new Kosaraju(vertexCount);
        for (int i = 0; i < vertexCount; i++){
            Iterator<Integer> iterator = adj[i].listIterator();
            while(iterator.hasNext()){
                graph.adj[iterator.next()].add(i);
            }
        }
        return graph;
    }
    void fillOrder_0(int v, boolean[] visited, Stack stack){
        visited[v] = true;
        Iterator<Integer> iterator = adj[v].iterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if (!visited[n]){
                fillOrder_0(n, visited, stack);
            }
        }
    }
    void printSccs_0(){
        Stack stack = new Stack();
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            if (!visited[i]){
                fillOrder(i, visited, stack);
            }
        }
        Kosaraju graph = getTranspose();
        for (int i = 0; i < vertexCount; i++){
            visited[i] = false;
        }
        while(!stack.empty()){
            int v = (int) stack.pop();
            if (!visited[v]){
                graph.dfSearchUtil_0(v, visited);
                System.out.println();
            }
        }
    }

    //Date 25 june
    //------------------------------



















}
