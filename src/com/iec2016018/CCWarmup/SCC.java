package com.iec2016018.CCWarmup;

import java.util.*;

public class SCC {

    private static Stack<Integer> stack;
    private static boolean addToStack = false;
    private static boolean rememberPath = false;
    private static ArrayList<Integer> currentPath = new ArrayList<>();

    public int kosaraju(ArrayList<ArrayList<Integer>> list, int N)
    {
        // your code here

        for (int i = 0 ; i < list.size() ; i++){
            System.out.println("list " + i + " : " + list.get(i));
        }

        stack = new Stack<>();
        addToStack = true;
        dfSearch(list, 1, null);
        list = reverseGraph(list);
        System.out.println("after reversing:");
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println("list " + i + " : " + list.get(i));
        }
        rememberPath = true;
        int scc = 0;
        System.out.println("stack is " + stack);
        boolean[] visited = new boolean[list.size()+1];
        while (!stack.empty()){
            int vertex = stack.pop();
            if (!visited[vertex]) {
                dfSearch(list, vertex, visited);
                //if (currentPath.get(0).equals(currentPath.get(currentPath.size() - 1))) {
                //}
                scc++;
            }
        }

        return scc;
    }

    private static void dfSearchUtil(ArrayList<ArrayList<Integer>> list, int vertex, boolean[] visited){
        visited[vertex] = true;
        if (addToStack){
            stack.add(vertex);
        }
        if (rememberPath){
            currentPath.add(vertex);
        }
        Iterator<Integer> iterator = list.get(vertex).listIterator();
        while(iterator.hasNext()){
            vertex = iterator.next();
            if (!visited[vertex]){
                dfSearchUtil(list, vertex, visited);
            }
        }
    }
    private static void dfSearch(ArrayList<ArrayList<Integer>> list, int vertex, boolean[] visited){
        if (visited == null){
            visited = new boolean[list.size()];
        }
        currentPath.clear();
        System.out.println("search vertex is " + vertex);
        dfSearchUtil(list, vertex, visited);
    }

    private static ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> list){

        ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();

        for (int i = 0 ; i < list.size() ; i++){
            reversed.add(new ArrayList<>());
        }

        for (int i = 0 ; i < list.size() ; i++){
            ArrayList<Integer> currentList = list.get(i);
            for (int j = 0 ; j < currentList.size() ; j++){
                reversed.get(currentList.get(j)).add(i);
            }
        }
        return reversed;
    }

}
