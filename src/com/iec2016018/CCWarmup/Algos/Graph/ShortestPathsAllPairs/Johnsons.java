package com.iec2016018.CCWarmup.Algos.Graph.ShortestPathsAllPairs;

public class Johnsons {

    // Johnson's algorithm for all-pairs shortest paths

    /*
            A L G O

        1)  Let the given graph be G. Add a new vertex s to the graph, add
            edges to new vertex to all vertices of G. Let the modifies
            graph be G'.
        2)  Run Bellman-Ford algorithm on G' with s as source. Let the
            distances calculated by Bellman-Ford be h[0], h[1],...h[vertexCount-1].
            If we find a negative weight cycle, then return. Note that the
            negative weihtcycle cannot be created by new vertex s as there
            is no edge to s. All edges are from s.
        3)  Reweight the edges of original graph. For each edge (u, v),
            assign the new weight as "original weight + h[u] - h[v]".
        4) Remove the added vertex s and run Dijkstra's algorithm for every vertex


        NOTE: Java code unavailable on GFG
     */

}
