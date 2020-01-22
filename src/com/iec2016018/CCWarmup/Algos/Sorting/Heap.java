package com.iec2016018.CCWarmup.Algos.Sorting;

public class Heap {

    /*

            Heap sort

            ABOUT       :

        >   Comparison based sorting technique based on Binary Heap data structure

            COMPLEXITY  :   heapify     O ( log n )
                                        createAndBuildHeap()    O ( n  log n )

            VARIATIONS  :   Selection sort

     */

    void heapify(int[] arr, int length, int i){
        int largest = i;
        int left = 2 * i  + 1;
        int right = 2 * i  + 2;
        if (left < length && arr[largest] < arr[left])      largest = left;
        if (right < length && arr[largest] < arr[right])    largest = right;
        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, length, largest);
        }
    }
    void heapSort(int[] arr){
        int n = arr.length;
        for (int i = n/2 - 1 ; i >= 0 ; i--)    heapify(arr, n, i);
        for (int i = n-1 ; i >= 0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================



    //Date 25 dec
    //-------------------------- heap sort

    void heapify_1(int[] arr, int length, int i) {
        int largest = i;
        int left = 2 * i + 1, right = left + 1;
        if (left < length && arr[largest] < arr[left]) largest = left;
        if (right < length && arr[largest] < arr[right]) largest = right;
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify_1(arr, length, largest);
        }
    }
    void sort_1(int[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1 ; i >= 0 ; i--) heapify(arr, n, i);
        for (int i = n - 1 ; i >= 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify_1(arr, n, 0);
        }
    }

    //------------------------------ heap sort

    void heapify_2(int[] arr, int length, int i) {
        int largest = i;
        int left = 2 * i + 1, right = left + 1;
        if (left < length && arr[largest] < arr[left]) largest = left;
        if (right < length && arr[largest] < arr[right]) largest = right;
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify_2(arr, length, largest);
        }
    }

    void heapSort_2(int[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1 ; i >= 0 ; i--)    heapify_2(arr, n, i);
        for (int i = n - 1 ; i >= 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify_2(arr, n, 0);
        }
    }





























}
