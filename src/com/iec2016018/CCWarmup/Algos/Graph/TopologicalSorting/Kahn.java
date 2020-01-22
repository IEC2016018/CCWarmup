package com.iec2016018.CCWarmup.Algos.Graph.TopologicalSorting;

import java.util.*;

public class Kahn {

    int vertexCount;// No. of vertices

    //An Array of List which contains
    //references to the Adjacency List of
    //each vertex
    List<Integer> adj[];
    public Kahn(int V)// Constructor
    {
        this.vertexCount = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i]=new ArrayList<Integer>();
    }

    // function to add an edge to graph
    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }

    // prints a Topological Sort of the complete graph
    public void topologicalSort()
    {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        int indegree[] = new int[vertexCount];

        // Traverse adjacency lists to fill indegrees of
        // vertices. This step takes O(vertexCount+E) time
        for(int i = 0; i < vertexCount; i++)
        {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for(int node : temp)
            {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue all vertices with
        // indegree 0
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < vertexCount; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result (A topological
        // ordering of the vertices)
        Vector<Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty())
        {
            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            int u=q.poll();
            topOrder.add(u);

            // Iterate through all its neighbouring nodes
            // of dequeued node u and decrease their in-degree
            // by 1
            for(int node : adj[u])
            {
                // If in-degree becomes zero, add it to queue
                if(--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if(cnt != vertexCount)
        {
            System.out.println("There exists a cycle in the graph");
            return ;
        }

        // Print topological order
        for(int i : topOrder)
        {
            System.out.print(i+" ");
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Topological Sort

            >   Topological sorting is a linear ordering of vertices such that for
                every directed edge uv, vertex u comes before v in the ordering
            >   Not possible if the graph is not a Directed Acyclic Graph (DAG)

            C O M P L E X I T Y     :   O (V + E)

     */

    void kahnSort_1() {
        int[] indegree = new int[vertexCount];
        for (int i = 0 ; i < vertexCount ; i++) {
            for (int n: adj[i]) {
                indegree[n]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0 ; i < vertexCount ; i++) {
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
        if (count != vertexCount) System.out.println("Graph contains cycle");
    }







}
