package com.iec2016018.CCWarmup.Algos.Searching;

public class Interpolation {

    /*

            Exponential search

            ABOUT       :

        >

            COMPLEXITY  :   O ( log (log n) )       <- For uniform distribution

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    static int interpolationSearch(int[] arr, int x){
        int low = 0, high = arr.length-1;
        while(low <= high && x >= arr[low] && x <= arr[high]){
            if (low == high){
                if (arr[low] == x) return low;
                return -1;
            }
            int pos =  low + ((high-low) / (arr[high]-arr[low]) * arr[low]);
            if (arr[pos] == x)  return pos;

            if (arr[pos] < x)   low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //------------------------------















}
