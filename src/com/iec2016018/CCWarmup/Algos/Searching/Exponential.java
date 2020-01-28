package com.iec2016018.CCWarmup.Algos.Searching;

import java.util.Arrays;

public class Exponential {

    /*

            E X P O N E N T I A L  S E A R C H  --

            ABOUT       :

        >

            COMPLEXITY     :   O (log n)

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

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


    //------------------------------


}
