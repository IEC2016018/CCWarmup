package com.iec2016018.CCWarmup.Algos.Sorting.Hybrids;

public class Shell {

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        printArray(arr);

        Shell ob = new Shell();
        ob.sort(arr);

        System.out.println("Array after sorting");
        printArray(arr);
    }

    /* An utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /* function to sort arr using shellSort */
    int sort(int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }


    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            Shell sort

            >   Variation of insertion Sort
            >   Elements are moved only one position ahead
            >   When an element has to be moved far ahead, many movements are involved
            >   Idea of shellSort is to allow exchange of far items

            C O M P L E X I T Y     :   O ( n^2 )

     */

    void shellSort_0(int[] arr){
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

    // Date: 26 dec
    //-------------------------------------

    void shellSort_1(int[] arr){
        int n = arr.length;
        for (int gap = n/2 ; gap > 0 ; gap /= 2) {
            for (int i = gap ; i < n ; i++){
                int temp = arr[i];
                int j;
                for (j = i ; j >= gap && arr[j-gap] >= temp ; j -= gap)
                    arr[j] = arr[j-gap];
                arr[j] = temp;
            }
        }
    }

    //------------- shell sort

    void shellSort_2(int[] arr){
        int n = arr.length;
        for (int gap  = n/2 ; gap > 0 ; gap /= 2) {
            for (int i = gap ; i < n ; i++){
                int temp = arr[i];
                int j;
                for (j = i ; j >= gap && arr[j-gap] >= temp ; j -= gap)
                    arr[j] = arr[j-gap];
                arr[j] = temp;
            }
        }
    }




















}
