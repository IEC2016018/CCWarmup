package com.iec2016018.CCWarmup.Algos.Graph.TopologicalSorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    private int vertexCount;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    //Constructor
    TopologicalSort(int v)
    {
        vertexCount = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < vertexCount; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    void topologicalSortUtil_0(int v, boolean[] visited, LinkedList<Integer> topOrder){
        visited[v] = true;
        for (int node : adj[v]) {
            if (!visited[node]) topologicalSortUtil_0(node, visited, topOrder);
        }
        topOrder.add(v);
    }
    void topologicalSort_0(){
        LinkedList<Integer> topOrder = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            if (!visited[i]) topologicalSortUtil_0(i, visited, topOrder);
        }
    }

    //Date 2 jan 2020
    //---------------------------------

    void topologicalSortUtil_1(int v, boolean[] visited, LinkedList<Integer> topOrder) {
        visited[v] = true;
        for (int node: adj[v]) {
            if (!visited[node]) topologicalSortUtil_1(node, visited, topOrder);
        }
        topOrder.add(v);
    }
    void topologicalSort_1() {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> topOrder = new LinkedList<Integer>();
        for (int i = 0 ; i < vertexCount ; i++) {
            if (!visited[i]) topologicalSortUtil_1(i, visited, topOrder);
        }
    }









}
