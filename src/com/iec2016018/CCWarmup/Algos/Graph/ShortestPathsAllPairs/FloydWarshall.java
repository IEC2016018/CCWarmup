package com.iec2016018.CCWarmup.Algos.Graph.ShortestPathsAllPairs;

public class FloydWarshall {

    final static int INF = 99999, vertexCount = 4;

    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i = 0; i< vertexCount; ++i)
        {
            for (int j = 0; j< vertexCount; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        FloydWarshall a = new FloydWarshall();

        // Print the solution
        a.floydWarshall(graph);
    }

    void floydWarshall(int graph[][])
    {
        int dist[][] = new int[vertexCount][vertexCount];
        int i, j, k;

        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        for (i = 0; i < vertexCount; i++)
            for (j = 0; j < vertexCount; j++)
                dist[i][j] = graph[i][j];

        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of an iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of an iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < vertexCount; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < vertexCount; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < vertexCount; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    // floys warshall all pairs shortest path problem

    /*
            A L G O

        We initialize the solution matrix same as the input graph matrix
        as a first step.
        Then we update the solution matrix by considering all vertices as
        an intermediate vertex.

        The idea is one by one pick all vertices and updates all shortest
        paths which include the picked vertex as an intermediate vertex,
        we already have considered vertices (0, 1, 2,...k-1) as intermediate
        vertices. For every pair (i, j) of the source and destination vertices
        respectively, there are two possible cases.
        1)  k is not an intermediate vertex in shortest path from i to j. We
        keep the value of dist[i][j] as it is.
        2)  k is an intermediate vertex in shortest path from i to j. We
        update the value of dist[i][j] as dist[i][k] + dist[k][j] if
        dist[i][j] > dist[i][k] + dist[k][j]

     */

    void floydWarshall_0(int[][] graph){
        int[][] dist = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                dist[i][j] = graph[i][j];
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                for (int k = 0; k < vertexCount; k++) {
                    if (dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
        printSolution(dist);
    }

    //Date 25 june
    //---------------------------------










}
