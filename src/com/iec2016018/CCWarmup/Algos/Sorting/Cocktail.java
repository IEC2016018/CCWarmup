package com.iec2016018.CCWarmup.Algos.Sorting;

public class Cocktail {

    /*
            C O C K T A I L  S O R T  --

            ABOUT       :

        >   Variation of Bubble sort
        >   Bubble sort algo always traverses elements from left and moves the
            largest element to its correct position in first iteration and second
            largest in second iteration and so on. Cocktail sort traverses through
            a given array in both directions alternatively

            COMPLEXITY  :   O ( n )     -->     O ( n^2 )

            VARIATIONS  :



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
    void cocktailSort(int[] arr){
        boolean swapped = true;
        int start = 0, end = arr.length-1;
        while(swapped){
            swapped = false;
            for (int i = start ; i < end ; i++)
                if (compareSwap(arr, i+1, i)) swapped = true;
            if (!swapped) break;
            swapped = false;
            end--;
            for (int i = end ; i >= start ; i--)
                if (compareSwap(arr, i+1, i)) swapped = true;
            start++;
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    // Date: 19 dec
    //------------------------------------- cocktail sort with complexity n -> n sq





























}
