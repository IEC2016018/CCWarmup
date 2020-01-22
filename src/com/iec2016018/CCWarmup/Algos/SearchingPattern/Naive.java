package com.iec2016018.CCWarmup.Algos.SearchingPattern;

public class Naive {

    public static void main(String[] args)
    {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(txt, pat);
    }

    public static void search(String txt, String pat)
    {
        int M = pat.length();
        int N = txt.length();

        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) {

            int j;

            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at index " + i);
        }
    }

    /*  A modified Naive Pettern Searching
        algorithn that is optimized for the
        cases when all characters of pattern are different
        */
    static void searchOptimized(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int i = 0;

        while (i <= N - M)
        {
            int j;

            /* For current index i, check for pattern match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            {
                System.out.println("Pattern found at index "+i);
                i = i + M;
            }
            else if (j == 0)
                i = i + 1;
            else
                i = i + j; // slide the pattern by j
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================

    /*

            N A I V E  P A T T E R N  S E A R C H  --

            ABOUT       :

        >   Naive pattern searching or native pattern searching algo

            COMPLEXITY     :   O ( n )     best case
                                        O (m *( n -m +1 ))  worst case

            VARIATIONS  :



     */

    static void naiveSearch_0(String txt, String pat){
        int patternLength = pat.length();
        int txtLength = txt.length();
        for (int i = 0 ; i <= txtLength - patternLength ; i++){
            int j;
            for (j = 0 ; j < patternLength ; j++){
                if (txt.charAt(i+j) != pat.charAt(j)) break;
            }
            if (j == patternLength){
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    // Date: 25 june
    //-------------------------------------

}
