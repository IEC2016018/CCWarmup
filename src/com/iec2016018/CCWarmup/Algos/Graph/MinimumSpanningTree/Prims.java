package com.iec2016018.CCWarmup.Algos.Graph.MinimumSpanningTree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static java.lang.Integer.MAX_VALUE;

public class Prims {

    class MyNode {

        // Stores destination vertex in adjacency list
        int dest;

        // Stores weight of a vertex in adjacency list
        int weight;

        // Constructor
        MyNode(int a, int b)
        {
            dest = a;
            weight = b;
        }
    }

    int vertices;
    LinkedList<MyNode>[] adj;

    static class Graph {

        // Number of vertices in the graph
        int vertices;

        // List of adjacent nodes of a given vertex
        LinkedList<MyNode>[] adj;

        // Constructor
        Graph(int e)
        {
            vertices = e;
            adj = new LinkedList[vertices];
            for (int o = 0; o < vertices; o++)
                adj[o] = new LinkedList<>();
        }
    }

    // class to represent a Node in PriorityQueue
    // Stores a vertex and its corresponding
    // key value
    class Node {
        int vertex;
        int key;
    }

    // Comparator class created for PriorityQueue
    // returns 1 if node0.key > MyNode.key
    // returns 0 if node0.key < MyNode.key and
    // returns -1 otherwise
    class comparator implements Comparator<Node> {

        @Override
        public int compare(Node node0, Node node1)
        {
            return node0.key - node1.key;
        }
    }

    // method to add an edge
    // between two vertices
    void addEdge(Graph graph, int src, int dest, int weight)
    {

        MyNode node0 = new MyNode(dest, weight);
        MyNode node = new MyNode(src, weight);
        graph.adj[src].addLast(node0);
        graph.adj[dest].addLast(node);
    }

    public static void main(String[] args)
    {
        int V = 9;

        Graph graph = new Graph(V);

        Prims e = new Prims();

        e.addEdge(graph, 0, 1, 4);
        e.addEdge(graph, 0, 7, 8);
        e.addEdge(graph, 1, 2, 8);
        e.addEdge(graph, 1, 7, 11);
        e.addEdge(graph, 2, 3, 7);
        e.addEdge(graph, 2, 8, 2);
        e.addEdge(graph, 2, 5, 4);
        e.addEdge(graph, 3, 4, 9);
        e.addEdge(graph, 3, 5, 14);
        e.addEdge(graph, 4, 5, 10);
        e.addEdge(graph, 5, 6, 2);
        e.addEdge(graph, 6, 7, 1);
        e.addEdge(graph, 6, 8, 6);
        e.addEdge(graph, 7, 8, 7);

        // Method invoked
        e.prims_mst(graph);
    }

    // method used to find the mst
    void prims_mst(Graph graph)
    {

        // Whether a vertex is in PriorityQueue or not
        Boolean[] mstset = new Boolean[graph.vertices];
        Node[] e = new Node[graph.vertices];

        // Stores the parents of a vertex
        int[] parent = new int[graph.vertices];

        for (int o = 0; o < graph.vertices; o++)
            e[o] = new Node();

        for (int o = 0; o < graph.vertices; o++) {

            // Initialize to false
            mstset[o] = false;

            // Initialize key values to infinity
            e[o].key = MAX_VALUE;
            e[o].vertex = o;
            parent[o] = -1;
        }

        // Include the source vertex in mstset
        mstset[0] = true;

        // Set key value to 0
        // so that it is extracted first
        // out of PriorityQueue
        e[0].key = 0;

        // PriorityQueue
        PriorityQueue<Node> queue = new PriorityQueue<>(graph.vertices, new comparator());

        for (int o = 0; o < graph.vertices; o++)
            queue.add(e[o]);

        // Loops until the PriorityQueue is not empty
        while (!queue.isEmpty()) {

            // Extracts a Node with min key value
            Node node0 = queue.poll();

            // Include that Node into mstset
            mstset[node0.vertex] = true;

            // For all adjacent vertex of the extracted vertex vertexCount
            // If vertexCount is in PriorityQueue
            // If the key value of the adjacent vertex is
            // more than the extracted key
            // update the key value of adjacent vertex
            // to update first remove and add the updated vertex
            for (MyNode iterator : graph.adj[node0.vertex])
                if (mstset[iterator.dest] == false) if (e[iterator.dest].key > iterator.weight) {
                    queue.remove(e[iterator.dest]);
                    e[iterator.dest].key = iterator.weight;
                    queue.add(e[iterator.dest]);
                    parent[iterator.dest] = node0.vertex;
                }
        }

        // Prints the vertex pair of mst
        for (int o = 1; o < graph.vertices; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Prim's Minimum Spanning Tree

            >   This is a greedy algo
            >

            C O M P L E X I T Y     :   O (V + E)

     */

    void primsMST_0(){
        boolean[] mstSet = new boolean[vertices];
        Node[] nodes = new Node[vertices];
        int[] parents = new int[vertices];
        for (int i = 0; i < vertices; i++){
            nodes[i] = new Node();
            nodes[i].key = MAX_VALUE;
            nodes[i].vertex = i;
            mstSet[i] = false;
            parents[i] = -1;
        }

        mstSet[0] = true;
        nodes[0].key = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(vertices, new comparator());
        for (int i = 0; i < vertices; i++) queue.add(nodes[i]);
        while(!queue.isEmpty()){
            Node node0 = queue.poll();
            mstSet[node0.vertex] = true;
            for (MyNode iterator : adj[node0.vertex])
                if (!mstSet[iterator.dest]) if (nodes[iterator.dest].key > iterator.weight) {
                    queue.remove(nodes[iterator.dest]);
                    nodes[iterator.dest].key = iterator.weight;
                    queue.add(nodes[iterator.dest]);
                    parents[iterator.dest] = node0.vertex;
                }
        }
        for (int i = 0; i < vertices; i++) System.out.println(parents[i] + " - " + i);
    }

    //Date 25 june
    //----------------------------------

    void primsMST_1() {
        Node[] nodes = new Node[vertices];
        boolean[] mstSet = new boolean[vertices];
        int[] parents = new int[vertices];
        for (int i = 0 ; i < vertices ; i++) {
            nodes[i] = new Node();
            nodes[i].key = MAX_VALUE;
            nodes[i].vertex = i;
            mstSet[i] = false;
            parents[i] = -1;
        }


    }




}
