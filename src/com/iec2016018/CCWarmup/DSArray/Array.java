package com.iec2016018.CCWarmup.DSArray;

import com.iec2016018.CCWarmup.DSLinkedList.Node;

import java.util.Arrays;

public class Array {

    public static void printArray(int[] array){

        for (int i = 0 ; i < array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void printArray(long[] array){

        for (int i = 0 ; i < array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void printArray(Integer[] array){

        for (int i = 0 ; i < array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static void drawMountain(int[] arr){
        int count = -1;
        while (++count < arr.length){
            int times = arr[count];
            System.out.print("|");
            while (times-->0){
                System.out.print("}");
            }
            System.out.println();
        }
        System.out.print("\n");
    }

    public static void print2D(int mat[][])
    {
        System.out.println("\n----------------------------------------------------------\n");
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));

        System.out.println("\n----------------------------------------------------------\n");

    }

    public static void print2DOfNodes(Node array[][]){

        System.out.println("\n\n--------- printing 2d array of Node s ------------------\n\n");

        int dataLength = 6;

        for (int i = 0 ; i < array.length ; i++){
            String row = "";
            int addSpace = 0;
            for (int j = 0 ; j < array[0].length ; j++){
                Node node = array[i][j];
                String str = "";
                if (node != null) {
                    str = String.valueOf(node.data);
                }else {
                    str = "_";
                }
                row += str;
                addSpace = dataLength - str.length();
                while (addSpace > 0){
                    row += " ";
                    addSpace--;
                }
            }
            System.out.println(row + "\n\n");
        }

        System.out.println("\n\n----------------------------------------------------------\n\n");

    }

}
