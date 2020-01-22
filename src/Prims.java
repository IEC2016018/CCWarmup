import java.util.Comparator;
import java.util.LinkedList;

public class Prims {

    class Node1 {

        // Stores destination vertex in adjacency list
        int dest;

        // Stores weight of vertex in adjacency list
        int weight;

        // constructor
        Node1(int a, int b){
            dest = a;
            weight = b;
        }

    }

    static class Graph{

        // Number of vertices in the graph
        int V;

        // List of adjacent nodes of a given vertex
        LinkedList<Node1>[] adj;

        // Constructor
        Graph(int e){
            V = e;
            adj = new LinkedList[V];
            for (int i = 0 ; i < V ; i++){
                adj[i] = new LinkedList<>();
            }
        }

    }

    // class to represent a node in priorityQueue
    // Stores a vertex and its corresponding
    // key value
    class Node{
        int vertex;
        int key;
    }

    // Comparator class created for PriorityQueue
    // returns 1 if node0.key > node1.key
    // returns 0 if node0.key < node1.key and
    // returns -1 otherwise
    class comparator implements Comparator<Node> {

        @Override
        public int compare(Node node0, Node node1){
            return node0.key - node1.key;
        }

    }

    // method to add an edge
    // between two vertices
    void addEdge(Graph graph, int src, int dest, int weight){

        Node1 node0 = new Node1(dest, weight);
        Node1 node = new Node1(src, weight);
        graph.adj[src].addLast(node0);
        graph.adj[dest].addLast(node);

    }

    // method used to find the mst


























}
