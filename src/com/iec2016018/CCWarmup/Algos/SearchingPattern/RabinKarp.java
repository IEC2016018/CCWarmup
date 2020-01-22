package com.iec2016018.CCWarmup.Algos.SearchingPattern;

public class RabinKarp {

    /*

            R A B I N  K A R P  A L G O  --

            ABOUT       :

      >     Rabin Karp algorithm matches the hash value of
            the pattern with the hash value of current substring
            of text,

            COMPLEXITY  :

            VARIATIONS  :

            ABBREVIATION:
            -   q   --> prime number

     */

    final static int length = 256;
    void rabinKarpSearch(String pat, String txt, int q) {
        int txtHash = 0, txtLen = txt.length();
        int patHash = 0, patLen = pat.length();
        int h = 1;
        for (int i = 0; i < patLen - 1; i++) {
            h = (h * length) % q;
        }
        for (int i = 0; i < patLen; i++) {
            patHash = (length * patHash + pat.charAt(i)) % q;
            txtHash = (length * txtHash + txt.charAt(i)) % q;
        }
        int j;
        for (int i = 0; i <= txtLen - patLen; i++) {
            if (patHash == txtHash) {
                for (j = 0; j < patLen; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) break;
                }
                if (j == patLen) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < txtLen - patLen) {
                txtHash = (
                        length * (txtHash - txt.charAt(i) * h)
                                + txt.charAt(i + patLen)
                        ) % q;
                if (txtHash < 0) txtHash = (txtHash + q);
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    // Date: 25 june
    //-------------------------------------









}
