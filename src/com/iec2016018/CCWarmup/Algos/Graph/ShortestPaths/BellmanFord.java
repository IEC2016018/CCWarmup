package com.iec2016018.CCWarmup.Algos.Graph.ShortestPaths;

public class BellmanFord {

    // A class to represent a weighted edge in graph
    class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    };

    static int vertexCount, edgeCount;
    Edge edge[];

    // Creates a graph with vertexCount vertices and edgeCount edges
    BellmanFord(int v, int e)
    {
        vertexCount = v;
        edgeCount = e;
        edge = new Edge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    // Driver method to test above function
    public static void main(String[] args)
    {
        int V = 5;  // Number of vertices in graph
        int E = 8;  // Number of edges in graph

        BellmanFord graph = new BellmanFord(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-edgeCount in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or edgeCount-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        graph.BellmanFord(graph, 0);
    }

    // A utility function used to print the solution
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }

    // The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm.  The
    // function also detects negative weight cycle
    void BellmanFord(BellmanFord graph, int src)
    {
        int V = graph.vertexCount, E = graph.edgeCount;
        int dist[] = new int[V];

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i=0; i<V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        // Step 2: Relax all edges |vertexCount| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |vertexCount| - 1 edges
        for (int i=1; i<V; ++i)
        {
            for (int j=0; j<E; ++j)
            {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u]!=Integer.MAX_VALUE &&
                        dist[u]+weight<dist[v])
                    dist[v]=dist[u]+weight;
            }
        }

        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.
        for (int j=0; j<E; ++j)
        {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u]+weight < dist[v])
                System.out.println("BellmanFord contains negative weight cycle");
        }
        printArr(dist, V);
    }

    // ==========================================================  P R A C T I C =======================================

    /*

            Bellman Ford's algo for shortest paths

            C O M P L E X I T Y     :    O ( vertexCount E )

            N O T E S

        1:  also work for graphs with negative weight edges
        2:  also simple than Dijkstra's and suited for distributed system
        3:  complexity is greater than Dijkstra's algo


            S T edgeCount P S

        1:  This step initializes distances from source to all vertices as
            infinite and distance to source itself as 0. Create an array
            dist[] of size [vertexCount] with all values as infinite except
            dist[src] where src is source vertex
        2:  This step calculates shortest distances. Do following |v|-1
            times where |vertexCount| is the number of vertices in given vertex
              a) Do following for each edge u-v
              ........If dist[v] > dist[u] + weight of edge uv, then update dist[v]
              .............. dist[v = dist[u] + weight of edge uv
        3:  This step reports if there is a negative weight cycle in graph. Do
            following for each edge u-v
            ...If dist[v] > dist[u] + weight of edge uv, then "BellmanFord contains
            negative weight cycle"

        The idea of step 3 is, step 2 guarantees shortest distances if graph
        doesn't contain negative weight cycle. If we iterate through all edges
        one more time and get a shorter path for any vertex, then there is a
        negative weight cycle

     */

    void bellmanFord_0(BellmanFord graph, int src){
        int[] dist = new int[vertexCount];
        for (int i = 0 ; i < vertexCount ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 1 ; i < vertexCount ; i++){
            for (int j = 0 ; j < edgeCount ; j++){
                int source = graph.edge[j].src;
                int dest = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[source] != Integer.MAX_VALUE &&
                dist[source] + weight < dist[dest]){
                    dist[dest] = dist[source] + weight;
                }
            }
        }
        for (int i = 0 ; i < edgeCount ; i++){
            int source = graph.edge[i].src;
            int dest = graph.edge[i].dest;
            int weight = graph.edge[i].weight;
            if (dist[source] != Integer.MAX_VALUE &&
            dist[source] + weight < dist[dest]){
                System.out.println("BellmanFord contains negative weight cycle");
            }
        }
        printArr(dist, vertexCount);
    }

    //Date 25 june
    //------------------------------------





}
