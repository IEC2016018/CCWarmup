package com.iec2016018.CCWarmup.Algos.Sorting;

public class Insertion {

    /*

            I N S E R T I O N  S O R T

            ABOUT       :

        >   Similar to how we sort playing cards

            COMPLEXITY  :  O ( n )  -->  O ( n ^ 2)

            VARIATIONS  :

     */

    // Without recursion
    void insertionSort(int[] arr){
        int n = arr.length;
        for (int i =1 ; i < n ; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    // With recursion
    void insertionSortRecursive(int[] arr, int n){
        if (n <= 1){
            return;
        }
        insertionSortRecursive(arr, n-1);
        int last = arr[n-1];
        int j = n-2;
        while (j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //Date 21 dec
    //----------------------------------- insertion sort with complexity n --> n^2
    void insertionSort_1(int[] arr) {
        for (int i = 1 ; i < arr.length ; i++) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = key;
        }
    }

    //----------------- insertion sort with complexity n --> n^2
    void insertionSort_2(int[] arr) {
        for (int i = 1 ; i < arr.length ; i++) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = key;
        }
    }














}
