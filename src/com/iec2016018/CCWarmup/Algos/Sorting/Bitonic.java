package com.iec2016018.CCWarmup.Algos.Sorting;

public class Bitonic {

    /*

            B I T O N I C  S O R T  --

            ABOUT       :

        >   Bitonic sequence are first increasing and then decreasing
        >   Time complexity is more than mergeSort [ does O (nLogn) ]
        >   Better for pallel implementation

            COMPLEXITY  :   O ( n log^2 n )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    void compareSwap(int[] arr, int i, int j, int dir){
        if ((arr[i] < arr[j] && dir == 0) ||
                (arr[j] < arr[i] && dir == 1)){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    void bitonicMerge(int[] arr, int low, int count, int dir){
        if (1 < count){
            int k = count/2;
            for (int i = low ; i < low+k ; i++){
                compareSwap(arr, i, i+k, dir);
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low+k, k, dir);
        }
    }
    void bitonicSort(int[] arr, int low, int count, int dir){
        if (1 < count){
            int k = count / 2;
            bitonicSort(arr, low, k, 1);
            bitonicSort(arr, low+k, k, 0);
            bitonicMerge(arr, low, count, dir);
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    //------------------------------------- bitonic sort with complexity n log sq n

    void compareSwap_1(int[] arr, int i, int j, int dir) {
        if ((arr[i] < arr[j] && dir == 0) || (arr[j] < arr[i] && dir == 1)) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    void bitonicMerge_1(int[] arr, int low, int count, int dir) {
        if (1 < count) {
            int k = count / 2;
            for (int i = low ; i < low+k ; i++) {
                compareSwap(arr, i, i+k, dir);
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low+k, k, dir);
        }
    }
    void bitonicSort_1(int[] arr, int low, int count, int dir) {
        if (1 < count) {
            int k = count / 2;
            bitonicSort(arr, low, k, 1);
            bitonicSort(arr, low+k, k, 0);
            bitonicMerge_1(arr, low, count, dir);
        }
    }

    //---------------- bitonic sort with complexity n log sq n

    void compareSwap_2(int[] arr, int i, int j, int dir) {
        if ((arr[i] < arr[j] && dir == 0) || (arr[j] < arr[i] && dir == 1)) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    void bitonicMerge_2(int[] arr, int low, int count, int dir) {
        if (1 < count) {
            int k = count / 2;
            for (int i = low ; i < low+k ; i++) {
                compareSwap_2(arr, i, i+k, dir);
            }
            bitonicMerge_2(arr, low, k, dir);
            bitonicMerge_2(arr, low+k, k, dir);
        }
    }
    void bitonicSort_2(int[] arr, int low, int count, int dir) {
        if (1 < count) {
            int k = count / 2;
            bitonicSort_2(arr, low, k, 1);
            bitonicSort_2(arr, low+k, k, 0);
            bitonicMerge_2(arr, low, count, dir);
        }
    }


















}
