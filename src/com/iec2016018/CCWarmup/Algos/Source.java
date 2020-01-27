package com.iec2016018.CCWarmup.Algos;

import java.util.LinkedList;

public class Source {

//    public static void print(String )
    public static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int src;
        public int dest;
        public int weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };

    // A class to represent a Subset for union-find
    public static class Subset {
        public int parent, rank;
    };

    int vertices;
    LinkedList<MyNode>[] adj;
    public static class MyNode {

        public int dest;
        public int weight;

        public MyNode(int a, int b) {
            dest = a;
            weight = b;
        }

    }

    public static class Graph {

        // Number of vertices in the graph
        public int vCount;     // vertexCount
        public int eCount;     // edgeCount

        public Graph() {}

        // List of adjacent nodes of a given vertex
        public LinkedList<MyNode>[] adj;

        public Edge[] edges;

        // Constructor
        public Graph(int vCount) {
            this.vCount = vCount;
            adj = new LinkedList[this.vCount];
            for (int o = 0; o < this.vCount; o++)
                adj[o] = new LinkedList<>();
        }
    }

    // class to represent a Node in PriorityQueue
    // Stores a vertex and its corresponding
    // key value
    public static class PqNode { // Priority queue node
        public int key;
        public int vertex;
    }

    // Comparator class created for PriorityQueue
    // returns 1 if node0.key > MyNode.key
    // returns 0 if node0.key < MyNode.key and
    // returns -1 otherwise


    // method to add an edge
    // between two vertices
    void addEdge(Graph graph, int src, int dest, int weight)
    {

        MyNode node0 = new MyNode(dest, weight);
        MyNode node = new MyNode(src, weight);
        graph.adj[src].addLast(node0);
        graph.adj[dest].addLast(node);
    }

    // A utility function used to print the solution
    public static void printArr(int dist[], int V) {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }

}
