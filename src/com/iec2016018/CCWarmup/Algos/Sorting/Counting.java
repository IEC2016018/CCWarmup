package com.iec2016018.CCWarmup.Algos.Sorting;

import java.util.Arrays;

public class Counting {

    /*

            C O U N T I N G  S O R T  --

            ABOUT       :

        >   Counting sort is efficient if the range of input data is not significantly greate than the number of objects
            to be stored. Consider the situation where the input sequesnce is between range 1 to 10 k and the data is ,
            10, 5, 10k, 5k.
        >   It is not a comparison based sorting.
        >   It is often used as a sub-routine to another sorting
            algorithm like radix sort.
        >   Counting sort uses a partial hashing to count the
            occurence of the data object in O(1)
        >   Counting sort can be extended to work for negative inputs also.

            COMPLEXITY  :   O ( n )

            VARIATIONS  :

     */

    void countSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for (int i : arr) count[i - min]++;
        for (int i = 1 ; i < count.length ; i++) count[i] += count[i-1];
        for (int i = arr.length - 1 ; i >= 0 ; i--) output[--count[arr[i] - min]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================




    //Date 26 dec
    //------------------------------- count sort with complexity n

























}
