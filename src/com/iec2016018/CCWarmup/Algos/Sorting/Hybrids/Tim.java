package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

public class Tim {

    /*

            T I M  S O R T  --

            ABOUT       :

        >   A stable sorting algorithm works in O(n log n) time
        >   Used in Java's Arrays.sort() as well as Python's sorted() and sort()
        >   First sort small pieces using Insertion Sort, then merges pieces
            using merge of merge sort

            COMPLEXITY     :   O ( n  log n )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    static int RUN = 32;

    void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (arr[j] > temp && j >= left)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    void merge(int[] arr, int l, int m, int r){
        int leftLength = m - l + 1, rightLength = r - m;
        int[] lefts = new int[leftLength], rights = new int[rightLength];
        System.arraycopy(arr, l, lefts, 0, leftLength);
        System.arraycopy(arr, m+1, rights, 0, rightLength);
        int i = 0, j = 0, k = l;
        while (i < leftLength && j < rightLength){
            if (lefts[i] < rights[j]) arr[k++] = lefts[i++];
            else arr[k++] = rights[j++];
        }
        System.arraycopy(lefts, 0, arr, k, leftLength-i);
        System.arraycopy(rights, 0, arr, k+leftLength-i, rightLength-j);
    }
    void timSort(int[] arr, int n){
        for (int i = 0 ; i < n ; i += RUN){
            insertionSort(arr, i, Math.min((i+31), (n-1)));
        }
        for (int size = RUN ; size < n ; size = 2*size){
            for (int left = 0 ; left < n ; left += 2*size){
                int mid = left + size - 1;
                int right = Math.min((left + 2*size - 1), (n-1));
                merge(arr, left, mid, right);
            }
        }
    }
    // ==========================================================  P R A C T I C E  H E R E ============================



    //-------------------------------------
    static void merge_1(int[] arr, int l, int m, int r){
        int leftLength = m - l + 1, rightLength = r - m;
        int[] lefts = new int[leftLength], rights = new int[rightLength];
        System.arraycopy(arr, l, lefts, 0, leftLength);
        System.arraycopy(arr, m+1, rights, 0, rightLength);
        int i = 0, j = 0, k = l;
        while (i < leftLength && j < rightLength){
            if (lefts[i] < rights[j]) arr[k++] = lefts[i++];
            else arr[k++] = rights[j++];
        }
        System.arraycopy(lefts, 0, arr, k, leftLength-i);
        System.arraycopy(rights, 0, arr, k+leftLength-i, rightLength-j);
    }
    static void timSort_1(int[] arr, int n){
        for (int i = 0 ; i < n ; i += RUN){
            //insertionSort();
        }
    }
















}
