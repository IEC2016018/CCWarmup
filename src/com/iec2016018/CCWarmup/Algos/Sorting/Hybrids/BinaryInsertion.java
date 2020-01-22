package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

import java.util.Arrays;

public class BinaryInsertion {

    public static void main(String[] args)
    {
        final int[] arr = {37, 23, 0, 17, 12, 72, 31,
                46, 100, 88, 54 };

        new BinaryInsertion().sort(arr);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    public void sort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int x = array[i];

            // Find location to insert using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            //Shifting array to one location right
            System.arraycopy(array, j, array, j+1, i-j);

            //Placing element at its correct location
            array[j] = x;
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Binary search

            C O M P L E X I T Y     :       O ( log n )



     */

    void binaryInsertionSort_0(int[] arr){
        for (int i = 1 ; i < arr.length ; i++){
            int x = arr[i];
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1);
            System.arraycopy(arr, j, arr, j+1, i-j);
            arr[j] = x;
        }
    }

    // Date: 25 june
    //-------------------------------------
    void binaryInsertionSort_1(int[] arr){
        int n = arr.length;
        for (int i = 1 ; i < n ; i++){
            int key = arr[i];
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, key)+1);
            System.arraycopy(arr, j, arr, j+1, i-j);
            arr[j] = key;
        }
    }
    //------------------------
    void binaryInsertionSort_2(int[] arr){
        int n = arr.length;
        for (int i = 1 ; i < n  ; i++){
            int key = arr[i];
            int insertAt = Math.abs(Arrays.binarySearch(arr, 0, i, key)+1);
            System.arraycopy(arr, insertAt, arr, insertAt+1, i-insertAt);
            arr[insertAt] = key;
        }
    }
    //------------------------ binary insertion sort with complexity O ( log n )
    void binaryInsertionSort_3(int[] arr){
        int n = arr.length;
        for (int i = 0 ; i < n ; i++){
            int key = arr[i];
            int insertAt = Math.abs(Arrays.binarySearch(arr, 0, i, key)+1);
            System.arraycopy(arr, insertAt, arr, insertAt+1, i-insertAt);
            arr[insertAt] = key;
        }
    }
    //-------------------- binary insertion sort with complexity O ( log n )
    void binaryInsertionSort_4(int[] arr){
        int length = arr.length;
        for (int i = 0 ;i < length ; i++){
            int key = arr[i];
            int insertAt = Math.abs(Arrays.binarySearch(arr, 0, i, key)+1);
            System.arraycopy(arr, insertAt, arr, insertAt+1, i-insertAt);
            arr[insertAt] = key;
        }
    }
    //------------------- binary insertion sort with complexity O (log n)
    void binaryInsertionSort_5(int[] arr){
        int length = arr.length;
        for (int i = 1 ; i < length ; i++){
            int key = arr[i];
            int insertAt = Math.abs(Arrays.binarySearch(arr, 0, i, key)+1);
            System.arraycopy(arr, insertAt, arr, insertAt+1, i-insertAt);
            arr[insertAt] = key;
        }
    }









}
