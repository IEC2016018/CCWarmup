package com.iec2016018.CCWarmup.Algos.Sorting;

public class Gnome {

    /*

            Gnome sort

            ABOUT       :

            Gnome Sort also called Stupid sort is based on the
            concept of a Garden Gnome sorting his flower pots.
            A garden gnome sorts the flower pots by the following
            method

            COMPLEXITY     :   O ( n )  to O ( n^2 )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    static void gnomeSort(int[] arr, int n){
        int index = 0;
        while(index < n){
            if (index == 0){
                index++;
            }
            if (arr[index] >= arr[index-1]){
                index++;
            }else {
                int temp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = temp;
                index--;
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //------------------------------------- gnome sort with complexity n -> n^2
    static void gnomeSort_1(int[] arr, int n){
        int index = 0;
        while (index < n){
            if (index == 0){
                index++;
            }
            if (arr[index] >= arr[index-1]) index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = temp;
                index--;
            }
        }
    }














}
