package com.iec2016018.CCWarmup.Algos.Graph.MinimumSpanningTree;

import com.iec2016018.CCWarmup.Algos.Source;
import com.iec2016018.CCWarmup.Algos.Source.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static java.lang.Integer.MAX_VALUE;

public class Prims {



    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            P R I M S  M S T  --

            ABOUT       :

            >   This is a greedy algo

            COMPLEXITY  :   O (V + E)

            VARIATIONS  :

     */

    static class comparator implements Comparator<Node> {

        @Override
        public int compare(Node node0, Node node1)
        {
            return node0.key - node1.key;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    void primsMST(LinkedList<MyNode>[] graph, int vertexCount){
        /*boolean[] mstSet = new boolean[vertexCount];
        PqNode[] nodes = new PqNode[vertexCount];
        int[] parents = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            nodes[i] = new PqNode();
            nodes[i].key = MAX_VALUE;
            nodes[i].vertex = i;
            mstSet[i] = false;
            parents[i] = -1;
        }

        mstSet[0] = true;
        nodes[0].key = 0;
        PriorityQueue<PqNode> queue = new PriorityQueue<PqNode>(vertexCount, new comparator());
        for (int i = 0; i < vertexCount; i++) queue.add(nodes[i]);
        while(!queue.isEmpty()){
            PqNode node0 = queue.poll();
            mstSet[node0.vertex] = true;
            for (MyNode iterator : graph[node0.vertex])
                if (!mstSet[iterator.dest]) if (nodes[iterator.dest].key > iterator.weight) {
                    queue.remove(nodes[iterator.dest]);
                    nodes[iterator.dest].key = iterator.weight;
                    queue.add(nodes[iterator.dest]);
                    parents[iterator.dest] = node0.vertex;
                }
        }
        for (int i = 0; i < vertexCount; i++) System.out.println(parents[i] + " - " + i);*/
    }

    //Date 1 Jan 2020
    //----------------------------------




}
