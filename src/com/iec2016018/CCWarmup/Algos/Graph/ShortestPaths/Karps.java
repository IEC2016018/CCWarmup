package com.iec2016018.CCWarmup.Algos.Graph.ShortestPaths;

public class Karps {

    // Karp's minimum mean (or average) weight cycle algorithm

    /*

            A L G O

        1:  Choose first vertex as source
        2:  Compute the shortest path to all other vertices
            on a path consisiting of k edges 0 <= k <= vertexCount
            where vertexCount is number of vertices.
            This is a simple dp problem which can be computed
            by the recursive solution
            dp[k][v] = min(dp[k][v], dp[k-1][u] + weight(u, v)
            where v is the destination and the edge(u, v) should
            belong to E
        3:  For each vertex calculate

                max(dp[n][v] - dp[k][v])
                ------------------------       where 0 <= k <= n-1
                          (n-k)

        4:  The minimum of the values calculated above is the
            required answer


            NOTE: Java code unavailable on GFG


     */



}
