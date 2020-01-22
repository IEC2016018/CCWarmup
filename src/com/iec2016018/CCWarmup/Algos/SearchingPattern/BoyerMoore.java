package com.iec2016018.CCWarmup.Algos.SearchingPattern;

public class BoyerMoore {

    /*

            B O Y E R  M O O R E  S E A R C H  --

            ABOUT       :

        >   Boyer moore is a combination of following two approaches
            -   Bad character heuristic
            -   Good suffix heuristic

            COMPLEXITY  :   O ( mn )        worstCase

            VARIATIONS  :

     */

    static int NO_OF_CHARS = 256;

    private void badCharHeuristic( char []str, int size,int badchar[]) {
        int i;
        for (i = 0; i < NO_OF_CHARS; i++) {
            badchar[i] = -1;
        }
        for (i = 0; i < size; i++) {
            badchar[(int) str[i]] = i;
        }
    }
    private void buyerMooreSearch(char[] txt, char[] pat){


        // ==========================================================  P R A C T I C E  H E R E ============================

        int s = 0;
        int patLen = pat.length;
        int txtLen = txt.length;
        int[] badChars = new int[NO_OF_CHARS];
        badCharHeuristic(pat, patLen, badChars);
        while(s <= (txtLen-patLen)){
            int j = patLen-1;
            while(j >= 0 && pat[j] == txt[s+j]){
                j--;
            }
            if (j < 0){
                System.out.println("Patterns occur at shift = " + s);
                s += (s + patLen < txtLen) ? patLen-badChars[txt[s+patLen]] : 1;
            }else {
                s += Math.max(1, j - badChars[txt[s+j]]);
            }
        }
    }

    // Date: 25 june
    //-------------------------------------


}
