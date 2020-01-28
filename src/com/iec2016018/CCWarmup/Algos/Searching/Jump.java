package com.iec2016018.CCWarmup.Algos.Searching;

public class Jump {

    /*

            J U M P  S E A R C H  --

            ABOUT       :

        >   TODO: pending...


            COMPLEXITY  :   O (sqrt(n))
                                        Depends on block size
                                        Worst case: ((n/m) + (m-1))

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    public static int jumpSearch(int[] arr, int x){
        int length = arr.length;
        int step = (int) Math.floor(Math.sqrt(length));
        int walk = step, prev = 0;

        while(arr[Math.min(walk, length)-1] < x){
            prev = step;
            walk += (int) Math.floor(Math.sqrt(length));
            if (prev >= length) return -1;
        }
        while(arr[prev] < x){
            prev++;
            if (prev == Math.min(walk, length)) return -1;
        }

        if (arr[prev] == x) return prev;

        return -1;
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //----------------------------



















}
