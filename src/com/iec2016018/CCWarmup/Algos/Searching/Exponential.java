package com.iec2016018.CCWarmup.Algos.Searching;

import java.util.Arrays;

public class Exponential {

    /*

            Exponential Search

            C O M P L E X I T Y     :   O (log n)

            A L G O

        1:  Find range where element is present
        2:  Do binary search in above found range

     */

    static int exponentialSearch(int[] arr, int n, int x){
        if (arr[0] == x) return 0;
        int i = 1;
        while(i < n && arr[i] <= x){
            i = i*2;
        }
        return Arrays.binarySearch(arr, i/2, Math.min(i, n), x);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 25 june
    //------------------------------


}
