package com.iec2016018.CCWarmup.Algos.SearchingPattern;

public class ZAlgo {

    /*

            Z  S E A R C H  --

            ABOUT       :

        >

            COMPLEXITY  :

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */

    public static void zSearch(String text, String pattern){
        String concat = pattern + "$" + text;
        int l = concat.length();
        int[] z = new int[l];
        getZarr(concat, z);
        for (int i = 0 ;i < l ; i++){
            if (z[i] == pattern.length()){
                System.out.println("Pattern found at index " +
                        (i - pattern.length() - 1));
            }
        }
    }
    private static void getZarr(String str, int[] z){
        int strLen = str.length();
        int L = 0, R = 0;
        for (int i = 1 ; i < strLen ; i++){
            if (i > R){
                L = R = i;
                while(R < strLen && str.charAt(R-L) == str.charAt(R)){
                    R++;
                }
                z[i] = R - L;
                R--;
            }else {
                int k = i - L;
                if (z[k] < R - i + 1){
                    z[i] = z[k];
                }else {
                    L = i;
                    while(R < strLen && str.charAt(R-L) == str.charAt(R)){
                        R++;
                    }
                    z[i] = R - L;
                    R--;
                }
            }
        }
    }

    // ==========================================================  P R A C T I C E  H E R E ============================


    //-------------------------------------



}
