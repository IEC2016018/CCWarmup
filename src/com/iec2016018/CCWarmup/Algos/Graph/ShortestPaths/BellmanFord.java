package com.iec2016018.CCWarmup.Algos.Graph.ShortestPaths;

import com.iec2016018.CCWarmup.Algos.Source;
import com.iec2016018.CCWarmup.Graph;

import static com.iec2016018.CCWarmup.Algos.Source.printArr;

public class BellmanFord {

    /*

            B L L M A N  F O R D S  S P  --

            ABOUT       :

        >   Also work for graphs with negative weight edges
        >   Also simple than Dijkstra's and suited for distributed system
        >   Complexity is greater than Dijkstra's algo

            COMPLEXITY     :    O ( vertexCount E )

            VARIATIONS  :

     */

    void bellmanFord(Graph graph, int src){
        int vCount = graph.vCount, eCount = graph.eCount;
        int[] dist = new int[vCount];
        for (int i = 0 ; i < vCount ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 1 ; i < vCount ; i++){
            for (int j = 0 ; j < eCount ; j++){
                int source = graph.edges[j].src;
                int dest = graph.edges[j].dest;
                int weight = graph.edges[j].weight;
                if (dist[source] != Integer.MAX_VALUE &&
                        dist[source] + weight < dist[dest]){
                    dist[dest] = dist[source] + weight;
                }
            }
        }
        for (int i = 0 ; i < eCount ; i++){
            int source = graph.edges[i].src;
            int dest = graph.edges[i].dest;
            int weight = graph.edges[i].weight;
            if (dist[source] != Integer.MAX_VALUE &&
                    dist[source] + weight < dist[dest]){
                System.out.println("BellmanFord contains negative weight cycle");
            }
        }
        printArr(dist, vCount);
    }

    // ==========================================================  P R A C T I C =======================================


    //Date 25 june
    //------------------------------------





}
