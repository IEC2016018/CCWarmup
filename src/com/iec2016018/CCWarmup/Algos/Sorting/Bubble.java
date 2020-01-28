package com.iec2016018.CCWarmup.Algos.Sorting;

public class Bubble {

    /*

            B U B B L E  S O R T  --

            ABOUT       :

        >   Simplest algo
        >   Works by repeatedly swapping the adjacent elements

            COMPLEXITY  :   O ( n )  -->    O ( n ^ 2 )

            VARIATIONS  :   Brick and Cocktail sorts

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    // --- without recursion
    void bubbleSort(int[] arr){
        for (int i = 0 ; i < arr.length-1 ; i++){
            boolean swapped = false;
            for (int j = 0 ; j < arr.length-i-1 ; j++){
                if (arr[j+1] < arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // --- with recursion
    void bubbleSortRecursive(int arr[], int n) {
        if (n == 1) return;
        for (int i=0; i<n-1; i++) {
            if (arr[i+1] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSortRecursive(arr, n-1);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    //----------------------------- bubble sort with complexity n to n sq


















}
