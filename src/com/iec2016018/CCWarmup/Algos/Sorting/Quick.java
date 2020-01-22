package com.iec2016018.CCWarmup.Algos.Sorting;

public class Quick {

    /*
            Q U I C K  S O R T

            ABOUT       :

        >   Divide and conquer algo
        >   It picks an element as pivot and partitions the given array
            around the picked pivot
        >   Ways of picking pivot:
            -   Always pick first element as pivot
            -   Always pick last element as pivot (implemented below)
            -   Pick a random element as pivot
            -   Pick median as pivot

            COMPLEXITY  :  T(n) = T(n/9) + T(9n/10) + \theta(n)

            VARIATIONS  :

     */

    // Without recursion
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    void sort(int[] arr, int low, int high){
        if (low < high){
            int part = partition(arr, low, high);
            sort(arr, low, part-1);
            sort(arr, part+1, high);
        }
    }

    // With recursion
    void quickSortRecursive(int[] arr, int low, int high){
        if (low < high){
            int part = partition(arr, low, high);
            quickSortRecursive(arr, low, part-1);
            quickSortRecursive(arr, part+1, high);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 25 dec
    //------------------------------------- quick sort








}
