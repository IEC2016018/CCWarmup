package com.iec2016018.CCWarmup.Algos.Sorting;

public class Pancake {

    /*

            P A N C A K E  S O R T

            ABOUT       :

        >   Allowd to do only following operation on array
            -->     flip(arr, i): Reverse array from 0 to i     <--

            COMPLEXITY  :   O ( n^2 )

            VARIATIONS  :



     */

    void flip(int[] arr, int i){
        int temp, start = 0;
        while(start < i){
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
    int findMax(int[] arr, int n){
        int maxAt = 0;
        for (int i = 0 ; i < n ; i++){
            if (arr[i] > arr[maxAt]) maxAt = i;
        }
        return maxAt;
    }
    void pancakeSort(int[] arr, int n){
        for (int i = n ; i > 1 ; i--){
            int maxAt = findMax(arr, i);
            if (maxAt != i-1){
                flip(arr, i);
                flip(arr, i-1);
            }
        }
    }


    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 28 dec
    //------------------------------------- pancake sort with complexity n^2

    void flip_1(int[] arr, int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
    int findMax_1(int[] arr, int before) {
        int maxAt = 0;
        for (int i = 0 ; i < before ; i++) {
            if (arr[maxAt] < arr[i]) maxAt = i;
        }
        return maxAt;
    }












}
