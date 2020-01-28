package com.iec2016018.CCWarmup.Algos.Sorting;

import static com.iec2016018.CCWarmup.Algos.Source.compareSwap;

public class Brick {

    /*

            B R I C K  S O R T / O D D - E V E N  S O R T  --

            ABOUT       :

        >   Also known as Odd-Even sort due to its odd-even sorting pattern

            COMPLEXITY  :   O ( n^2 )

            VARIATIONS  :   Bubble sort

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    boolean loopSwap(int[] arr, int start, int end) {
        boolean swapped = false;
        for (int i = start ; i < end ; i+=2) {
            if (compareSwap(arr, i+1, i)) swapped = true;
        }
        return swapped;
    }
    void brickSort(int[] arr, int n){
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            if (loopSwap(arr, 0, n-2)) swapped = true;
            if (loopSwap(arr, 1, n-2)) swapped = true;
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    //------------------------------------- brick or odd-even sort with complexity n sq







}














