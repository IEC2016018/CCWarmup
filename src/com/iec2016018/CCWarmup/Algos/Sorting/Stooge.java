package com.iec2016018.CCWarmup.Algos.Sorting;

public class Stooge {

    /*

            S T O O G E  S O R T  --

            ABOUT       :

        >

            COMPLEXITY  :   3T(3n/2) + ?(1)

            VARIATIONS  :


     */

    void stoogeSort(int[] arr, int l, int h){
        if (l >= h){
            return;
        }
        if (arr[l] > arr[h]){
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
        }
        if (h-l > 1){
            int t = (h -l +2) / 3;
            stoogeSort(arr, l, h-t);
            stoogeSort(arr, l+t, h);
            stoogeSort(arr, l, h-t);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 30 dec
    //-------------------------------------




}
