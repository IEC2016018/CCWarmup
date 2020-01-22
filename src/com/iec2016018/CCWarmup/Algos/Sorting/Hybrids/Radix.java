package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

import java.util.Arrays;

public class Radix {

    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }


    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Radix sort

            >   The lower bound for comparison based sorting algorithm (Merge Sort,
                Heap Sort, Quick Sort.. etc) is Q(nLogn), i.e, they cannot do better
                than nLogn
            >   Counting sort is a linear time sorting algorithm that sort in O(n+k) time
                when elements are in range from 1 to k

            C O M P L E X I T Y     :

     */
    void countSort_0(int[] arr, int n, int exp){
        int[] count = new int[10], output = new int[n];
        for (int i = 0 ; i < n ; i++)
            count[ (arr[i] / exp) % 10 ]++;
        for (int i = 1 ; i < 10 ; i++)
            count[i] += count[i-1];
        for (int i = n-1 ; i >= 0 ; i--)
            output[--count[ ( arr[i] / exp ) % 10 ]] = arr[i];
        System.arraycopy(output, 0, arr, 0, n);
    }
    void radixSort_0(int[] arr){
        int n = arr.length, max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1 ; max/exp > 0 ; exp += 10) countSort(arr, n, exp);
    }

    // Date: 26 dec
    //------------------------------------- radix sort with complexity d * (n+b);

    void countSort_1(int[] arr, int n, int exp) {
        int[] count = new int[10], output = new int[n];
        for (int i : arr)
            count[(arr[i]/exp) % 10]++;
        for (int i = 1 ; i < n ; i++)
            count[i] += count[i-1];
        for (int i = n-1 ; i >= 0 ; i--)
            output[--count[(arr[i]/exp) % 10]]  = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    void radixSort_1(int[] arr) {
        int n = arr.length, max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1 ; max/exp > 0 ; exp += 10) countSort(arr, n, exp);
    }

    //-------------------------------- radix sort with complexity d * (n+b)

    void countSort_2(int[] arr, int n, int exp) {
        int[] count = new int[10], output = new int[n];
        for (int i = 0 ; i < n ; i++)
            count[(arr[i]/exp) % 10]++;
        for (int i = 1 ; i < n ; i++)
            count[i] += count[i-1];
        for (int i = n-1 ; i >= 0 ; i--)
            output[--count[(arr[i] / exp) % 10]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    void radixSort_2(int[] arr) {
        int n = arr.length, max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1 ; max/exp > 0 ; exp += 10) countSort(arr, n, exp);
    }

    //------------------------------- radix sort with complexity d (n + b)

    void countSort_3(int[] arr, int n, int exp) {
        int[] count = new int[10], output = new int[n];
        for (int i = 0 ; i < n ; i++)
            count[arr[i]/exp % 10]++;
        for (int i = 1 ; i < n ; i++)
            count[i] += arr[i-1];
        for (int i = n-1 ; i >= 0 ; i--)
            output[--count[(arr[i]/exp) % 10]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    void radixSort_3(int[] arr) {
        int n = arr.length, max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1 ; max/exp > 0 ; exp += 10) countSort_3(arr, n, exp);
    }









}
