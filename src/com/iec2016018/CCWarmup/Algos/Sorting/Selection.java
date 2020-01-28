package com.iec2016018.CCWarmup.Algos.Sorting;

public class Selection {

    /*

            S E L E C T I O N  S O R T  --

            ABOUT       :

            >   Sorts by repeatedly finding the minimum element
            >   Algo maintains two subarrays in a given array

            COMPLEXITY  :   O ( n^2 )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0 ; i < n-1 ; i++){
            int minIndex = i;
            for (int j = i+1 ; j < n ; j++){
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //------------------------------------- Selection sort with complexity n^2




















}
