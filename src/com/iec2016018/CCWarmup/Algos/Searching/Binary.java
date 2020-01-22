package com.iec2016018.CCWarmup.Algos.Searching;

public class Binary {

    /*

            B I N A R Y  S E A R C H  --

            ABOUT       :

        >

            COMPLXITY   :   O ( log n )

            VARIATIONS  :



     */

    int binarySearch(int[] arr, int l, int r, int x){
        if (r >= l){
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)  return mid;
            if (arr[mid] > x)   return binarySearch(arr, l, mid-1, x);
            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }


    // ==========================================================  P R A C T I C E  H E R E ============================


    //Date 25 june
    // -------------------------------










}
