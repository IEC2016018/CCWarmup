package com.iec2016018.CCWarmup.Algos.SearchingPattern;

public class KnuthMorrisPratt {

    /*

            K N U T H  M O R R I S  P R A T T  S E A R C H  --

            ABOUT       :

        >

            COMPLEXITY  :   O ( n )             worst case

            VARIATIONS  :

            ABBREVIATION:                                                                           --  CASE INSENSITIVE
            -   kmp     ->  knuth morris pratt
            -   lps     ->  longest prefix suffix

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    void kmpSearch(String pat, String txt){
        int patLen = pat.length();
        int txtLen = txt.length();
        int[] lps = new int[patLen];
        int j = 0;
        computeLpsArray(pat, patLen, lps);
        int i = 0;
        while (i < txtLen){
            if (pat.charAt(j) == txt.charAt(i)){
                j++;
                i++;
            }
            if (j == patLen){
                System.out.println("Found pattern at index " + (i - j));
                j = lps[i-1];
            }else if (i < txtLen && pat.charAt(j) != txt.charAt(i)){
                if (j != 0){
                    j = lps[j-1];
                }else {
                    i++;
                }
            }
        }
    }
    void computeLpsArray(String pat, int patLength, int[] lps){
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i < patLength){
            if (pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else {
                if (len != 0){
                    len = lps[len-1];
                }else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //-------------------------------------









}
