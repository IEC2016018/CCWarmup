package com.iec2016018.CCWarmup.Algos.Sorting;

public class Brick {

    /*

            B R I C K  S O R T / O D D - E V E N  S O R T  --

            ABOUT       :

        >   Variation of Bubble sort
        >   Also known as Odd-Even sort because algo is divided into two phases-
            Odd and Even phase

            COMPLEXITY  :   O ( n^2 )

            VARIATIONS  :

     */

    boolean swap_0(int[] arr, int n, int start) {
        boolean swapped = false;
        for (int i = start ; i < n-2 ; i+=2) {
            if (arr[i+1] < arr[i]) {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
                swapped = true;
            }
        }
        return swapped;
    }
    void brickSort_0(int[] arr, int n){
        boolean swapped = true;
        while(swapped) swapped = swap_0(arr, n, 1) || swap_0(arr, n, 0);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    // Date: 17 JAN 2020
    //------------------------------------- brick or odd-even sort with complexity n sq

    boolean swap_1(int[] arr, int n, int start) {
        boolean swapped = false;
        for (int i = start ; i < n-2 ; i+=2) {
            if (arr[i+1] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swapped = true;
            }
        }
        return swapped;
    }
    void brickSort_1(int[] arr, int n) {
        boolean swapped = true;
        while(swapped) swapped = swap_1(arr, n, 1) || swap_1(arr, n, 0);
    }





}














