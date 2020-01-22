package com.iec2016018.CCWarmup.Algos.Sorting;

public class Merge {

    /*

            Merge sort

            ABOUT       :

        >   Divide and conquer algo
        >   Divide input array in two halves, calls itself for the two halves and
            then merges two sorted halves

            COMPLEXITY  :      log n

            VARIATIONS  :

            USAGE       :

        >   Sorting linked lists in O(nLogn) time
        >   Inversion count problem
        >   External sorting


     */

    // Without recursion
    void merge(int[] arr, int l, int m, int r){
        int leftLength = m - l + 1, rightLength = r - m;
        int[] lefts = new int[leftLength], rights = new int[rightLength];
        System.arraycopy(arr, l, lefts, 0, leftLength);
        System.arraycopy(arr, m+1, rights, 0, rightLength);
        int i = 0, j = 0, k = l;
        while( i < leftLength && j < rightLength){
            if (lefts[i] < rights[j]) arr[k] = lefts[i++];
            else arr[k] = rights[j++];
            k++;
        }
        System.arraycopy(lefts, i, arr, k, leftLength-i);
        System.arraycopy(rights, j, arr, k+leftLength-i, rightLength-j);
    }
    void sort(int[] arr, int l, int r){
        if (l < r){
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    // With recursion
    void mergeSortRecursive_0(int[] arr){
        if (arr == null) return;
        if (arr.length > 1){
            int mid = arr.length / 2;
            int[] left = new int[mid], right = new int[arr.length - mid];
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            mergeSortRecursive_0(left);
            mergeSortRecursive_0(right);
            int i = 0, j = 0, k = 0;
            while(i < left.length && j < right.length){
                if (left[i] < right[j])
                    arr[k++] = left[i++];
                else
                    arr[k++] = right[j++];
            }
            while(i < left.length)  arr[k++] = left[i++];
            while(j < right.length) arr[k++] = right[j++];
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //Date 26 nov
    //--------------------------- merge sort with  complexity log n

    void merge_1(int[] arr, int l, int m, int r) {
        int leftLength = m - l + 1, rightLength = r - m;
        int[] lefts = new int[leftLength], rights = new int[rightLength];
        System.arraycopy(arr, l, lefts, 0, leftLength);
        System.arraycopy(arr, m+1, rights, 0, rightLength);
        int i = 0, j = 0, k = l;
        while ( i < leftLength && j < rightLength) {
            if (lefts[i] < rights[j]) arr[k] = lefts[i++];
            else arr[k] = rights[j++];
            k++;
        }
        System.arraycopy(lefts, i, arr, k, leftLength - i);
        System.arraycopy(rights, j, arr, k + leftLength - i, rightLength - j);
    }

    void sort_1(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    //------------- merge sort with complexity logN

    void merge_2(int[] arr, int l, int m, int r) {
        int leftLength = m - l + 1, rightLength = r - m;
        int[] lefts = new int[leftLength], rights = new int[rightLength];
        System.arraycopy(arr, l, lefts, 0, leftLength);
        System.arraycopy(arr, m+1, rights, 0, rightLength);
        int i = 0, j = 0, k = l;
        while( i < leftLength && j < rightLength) {
            if (lefts[i] < rights[j]) arr[k] = lefts[i++];
            else arr[k] = rights[j++];
            k++;
        }
        System.arraycopy(lefts, i, arr, k, leftLength - i);
        System.arraycopy(rights, j, arr, k + leftLength - i, rightLength - j);
    }

    void sort_2(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r) / 2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }



















}
