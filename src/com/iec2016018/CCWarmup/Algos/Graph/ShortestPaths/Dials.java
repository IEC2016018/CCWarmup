package com.iec2016018.CCWarmup.Algos.Graph.ShortestPaths;

public class Dials {

    //TODO: pending...

    // Dial's Algorithm (Optimized Dijkstra for small range weights)

    /*
            A L G O

        1)  Maintains some buckets, numbered 0, 1, 2,...wV.
        2)  Bucket k contains all temporarily labeled nodes with distance equal to k
        3)  Nodes in each bucket are represented by list of vertices
        4)  Buckets 0, 1, 2,..wV are checked sequeantially untill the
            first non-empty bucket is found. Each node contained in the
            first non-empty bucket has the minimum distance label by definition.
        5)  One by one, these nodes with minimum distance label are
            permanently labeled and deleted from the bucket during the
            scanning process.
        6)  Thus operation involving vertex include:
            >   Checking if a bucket is empty
            >   Adding a vertex to a bucket
            >   Deleting a vertex from a bucket.
        7)  The position of temporarily labeled vertex in the buckets is
            updated accordingly when the distance label of a vertex changes.
        8)  Process repeated untill all vertices are permanently labeled
            (or distances of all vertices are finalized).

     */

}
