package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

public class Shell {

    /*

            S H E L L  S O R T  --

            ABOUT       :

        >   Variation of insertion Sort
        >   Elements are moved only one position ahead
        >   When an element has to be moved far ahead, many movements are involved
        >   Idea of shellSort is to allow exchange of far items

            COMPLEXITY  :   O ( n^2 )

            VARIATIONS  :



     */

    void shellSort(int[] arr){
        int n = arr.length;
        for (int gap = n/2 ; gap > 0 ; gap /= 2){
            for (int i = gap ; i < n ; i++){
                int temp = arr[i];
                int j;
                for (j = i ; j >= gap &&
                        arr[j-gap] > temp ; j -= gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 1 Jan 2020
    //-------------------------------------



}
