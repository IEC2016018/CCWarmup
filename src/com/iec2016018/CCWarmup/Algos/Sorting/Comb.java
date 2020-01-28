package com.iec2016018.CCWarmup.Algos.Sorting;

public class Comb {

    /*
            C O M B  S O R T  --

            ABOUT       :

        >   Improvement over bubble sort.
        >   It works better than Bubble Sort on average, worst case remains O(n^2)
        >   Comb sort improves on Bubble sort by using gap of size more that 1.

            COMPLEXITY  :   from O ( n ) to O ( n^2 )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    boolean compareSwap(int[] arr, int low, int high) {
        if (arr[low] < arr[high]) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            return true;
        }
        return false;
    }
    int getNextGap(int gap){
        gap = (gap*10) / 13;
        if (gap < 1){
            return 1;
        }
        return gap;
    }
    void combSort(int[] arr){
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        while(gap != 1 || swapped){
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0 ; i < n-gap ; i++){
                if (compareSwap(arr, i+gap, i)) swapped = true;
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    //------------------------------------- comb sort with complexity n -> n sq
























}
