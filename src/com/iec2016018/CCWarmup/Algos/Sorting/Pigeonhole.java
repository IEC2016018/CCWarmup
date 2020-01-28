package com.iec2016018.CCWarmup.Algos.Sorting;

import java.util.Arrays;

public class Pigeonhole {

    /*

            Pigeonhole sort

            ABOUT       :

        >   Suitable for sorting lists of elements where the number of elements
            and the number of possible key values are approximately the same.

            COMPLEXITY  :   O ( length + range )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    void pigonholeSort(int[] arr){
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] holes = new int[range];
        for (int value : arr) holes[value - min]++;
        int index = 0;
        for (int i = 0 ; i < range ; i++){
            while(holes[i]-->0){
                arr[index++] = i + min;
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //------------------------------------- pigeonhole sort with complexity (n + range)

    void pigeonholeSort_1(int[] arr){
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] holes = new int[range];
        for (int i: arr) holes[i-min]++;
        int index = 0;
        for (int i = 0 ; i < range ; i++) arr[index++] = i + min;
    }

    //---------------------- pigeonhole sort with complexity (n + range)

    void pigeonholeSort_2(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] holes = new int[range];
        for (int i: arr) holes[i-min]++;
        int index = 0;
        for (int i = 0 ; i < range ; i++) arr[index++] = i+min;
    }

















}
