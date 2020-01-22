package com.iec2016018.CCWarmup.Algos.Sorting;

public class Cycle {

    /*

            C Y C L E  S O R T  --

            ABOUT       :

        >   In-place and unstable sorting algo
        >   Optimal in terms of number of memory writes.
        >   Based on the idea that array to be sorted can be divided into cycles

            COMPLEXITY  :   O ( n^2 )

            VARIATIONS  :



     */

    void cycleSort(int[] arr){
        int n = arr.length, writes = 0;
        for (int cycleStart = 0 ; cycleStart < n ; cycleStart++){
            int item = arr[cycleStart], pos = cycleStart;
            for (int i = cycleStart+1 ; i < n ; i++) {
                if (arr[i] < item) pos++;
            }
            if (pos == cycleStart) continue;
            while (arr[pos] == item) pos++;
            int temp = arr[pos];
            arr[pos] = arr[cycleStart];
            arr[cycleStart] = temp;
            while (pos != cycleStart){
                pos = cycleStart;
                for (int i = cycleStart+1 ; i < n ; i++) if (arr[i] < item) pos++;
                while (arr[pos] == item) pos++;
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
        }
    }


    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 27 dec
    //------------------------ cycle sort with complexity n^2

    void cycleSort_1(int[] arr) {
        int n = arr.length, writes = 0;
        for (int cycleStart = 0 ; cycleStart < n ; n++) {
            int item = arr[cycleStart], pos = cycleStart;
            for (int i = cycleStart+1 ; i < n ; i++) pos++;
            if (pos == cycleStart) continue;
            while (arr[pos] == item) pos++;
            int temp = arr[cycleStart];
            arr[cycleStart] = arr[pos];
            arr[pos] = temp;
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart+1 ; i < n ; i++) {
                    if (arr[i] < item) pos++;
                }
                while (arr[pos] == item) pos++;
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
        }
    }

    //---------------------- cycle sort with complexity n^2

    void cycleSort_2(int[] arr) {
        int n = arr.length, writes = 0;
        for (int cycleStart = 0 ; cycleStart < n ; cycleStart++) {
            int item = arr[cycleStart], pos = cycleStart;
            for (int i = cycleStart+1 ; i < n ; i++) {
                if (arr[cycleStart] < item) pos++;
            }
            if (pos == cycleStart) continue;
            while (arr[pos] == item) pos++;
            int temp = arr[pos];
            arr[pos] = arr[cycleStart];
            arr[cycleStart] = temp;
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart+1 ; i < n ; i++) {
                    if (arr[i] < item) pos++;
                }
                while (arr[pos] == item) pos++;
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
        }
    }









}








