package com.iec2016018.CCWarmup.Algos.Graph.ShortestPaths;

public class Dijkstras {

    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Dijkstras t = new Dijkstras();
        t.dijkstra(graph, 0);
    }

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int vertexCount =9;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < vertexCount; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < vertexCount; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation

    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[vertexCount]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[vertexCount];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < vertexCount; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < vertexCount -1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < vertexCount; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist, vertexCount);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    // Dijkstra's shortes path algorithm

    /*

            C O M P L E X I T Y

            O(VLogV) (with the use of Fibonacci heap)

            N O T E S

            Dijkstra's algo doesn't work for graphs with negative edges


            S T E P S

        1:  Create a set sptSet (Shortest path tree set) that keeps track of
            vertices included in shortest path tree, i.e., whose minimum
            distance from source is calculated and finalized. Initially, this
            set is empty
        2:  Assign a distance value to all vertices in the input graph.
            Initialize all distance values as INFINITE. Assign distance value
            as 0 for the source vertex so that it is picked first.
        3:  While sptSet doesn't include all vertices
            a)  Pick a vertex u which is not there in sptSet and has minimum
            distance value
            b) Include u to sptSet
            c) Update distance value of all adjacent vertices of u. To update the
            distance values, iterate through all adjacent vertices. For every
            adjacent vertex v, If sum of distance value of u (from source) and
            weight of edge u-v, is less than the distance value of v, then update
            the distance value of v.

     */

    int minDistance_0(int[] dist, boolean[] shortestPaths){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < vertexCount; i++){
            if (!shortestPaths[i] && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    void dijkstra_0(int[][] graph, int src){
        int[] dist = new int[vertexCount];
        boolean[] shortestPaths = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 0; i < vertexCount -1 ; i++){
            int u = minDistance_0(dist, shortestPaths);
            shortestPaths[u] = true;
            for (int v = 0; v < vertexCount; v++){
                if (!shortestPaths[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist, vertexCount);
    }

    //Date 25 june
    // ---------------------------------

















}
