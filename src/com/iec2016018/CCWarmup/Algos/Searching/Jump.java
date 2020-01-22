package com.iec2016018.CCWarmup.Algos.Searching;

public class Jump {

    /*

            J U M P  S E A R C H  --

            ABOUT       :
        >   Works only sorted arrays.
        >   The optimal size of a block to be jumped is (√ n). This makes the
            time complexity of Jump Search O(√ n).
        >   The time complexity of Jump Search is between Linear Search ( ( O(n) )
            and Binary Search ( O (Log n) ).
        >   Better than Jump Search, but Jump search has an advantage that we traverse
            back only once (Binary Search may require up to O(Log n) jumps, consider a
            situation where the element to be search is the smallest element or smaller
            than the smallest). So in a systems where jumping back is costly, we use Jump Search.

            In the worst case, we have to do n/m jumps and if the last checked value is
            greater than the element to be searched for, we perform m-1 comparisons more for
            linear search. Therefore the total number of comparisons in the worst case will
            be ((n/m) + m-1). The value of the function ((n/m) + m-1) will be minimum when
            m = √n. Therefore,
            the best step size is m = √n.

            COMPLEXITY  :   O (sqrt(n))
                                        Depends on block size
                                        Worst case: ((n/m) + (m-1))

            VARIATIONS  :

            ABOUT       :



            VARIATIONS  :

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


    // Date: 25 june
    //----------------------------



















}
