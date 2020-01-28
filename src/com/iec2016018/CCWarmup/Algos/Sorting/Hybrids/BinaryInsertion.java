package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

import java.util.Arrays;

public class BinaryInsertion {

    /*

            B I N A R Y  S E A R C H  --

            ABOUT       :

        >

            COMPLEXITY  :       O ( log n )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    void binaryInsertionSort(int[] arr){
        for (int i = 1 ; i < arr.length ; i++){
            int x = arr[i];
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1);
            System.arraycopy(arr, j, arr, j+1, i-j);
            arr[j] = x;
        }
    }


    // ==========================================================  P R A C T I C E  H E R E ============================


    //-------------------------------------







}
