package com.iec2016018.CCWarmup.Algos.Searching;

public class Fibonacci {


    /*

            F I B O N A C C I  S E A R C H  --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

     */
    public static int fibonacci(int[] arr, int x, int n){
        int num_1 = 0, num_2 = 1, num_3 = num_1 + num_2;
        while(num_3 < n){
            num_1 = num_2;
            num_2 = num_3;
            num_3 = num_2 + num_1;
        }
        int offset = -1;
        while(num_3 > 1){
            int i = Math.min(offset + num_1, n - 1);
            if (arr[i] < x){
                num_3 = num_2;
                num_2 = num_1;
                num_1 = num_3 - num_2;
                offset = i;
            }else if (arr[i] > x){
                num_3 = num_1;
                num_2 = num_2 - num_1;
                num_1 = num_3 - num_2;
            }else return i;
        }
        if (num_2 == 1 && arr[offset+1] == x) return offset+1;
        return -1;
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    // Date: 25 june
    //-----------------------------------




















}
