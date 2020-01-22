package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

public class Tim {

    static int RUN = 32;

    // utility function to print the Array
    public static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {5, 21, 7, 23, 19};
        int n = arr.length;
        System.out.print("Given Array is\n");
        printArray(arr, n);

        timSort(arr, n);

        System.out.print("After Sorting Array is\n");
        printArray(arr, n);
    }

    // this function sorts array from left index to
    // to right index which is of size atmost RUN
    public static void insertionSort(int[] arr, int left, int right)
    {
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

    // merge function merges the sorted runs
    public static void merge(int[] arr, int l,
                             int m, int r)
    {
        // original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // after comparing, we merge those two array
        // in larger sub array
        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of left, if any
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // copy remaining element of right, if any
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // iterative Timsort function to sort the
    // array[0...n-1] (similar to merge sort)
    public static void timSort(int[] arr, int n)
    {

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += RUN)
        {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }

        // start merging from size RUN (or 32). It will merge
        // to form size 64, then 128, 256 and so on ....
        for (int size = RUN; size < n; size = 2 * size)
        {

            // pick starting point of left sub array. We
            // are going to merge arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we increase left by 2*size
            for (int left = 0; left < n; left += 2 * size)
            {

                // find ending point of left sub array
                // mid+1 is starting point of right sub array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                merge(arr, left, mid, right);
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Tim sort

            >   A stable sorting algorithm works in O(n log n) time
            >   Used in Java's Arrays.sort() as well as Python's sorted() and sort()
            >   First sort small pieces using Insertion Sort, then merges pieces
                using merge of merge sort

            C O M P L E X I T Y     :   O ( n  log n )

     */

    public static void insertionSort_0(int[] arr, int left, int right)
    {
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
    static void merge_0(int[] arr, int l, int m, int r){
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
    static void timSort_0(int[] arr, int n){
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

    // Date: 26 june
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
