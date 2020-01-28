package com.iec2016018.CCWarmup.Algos.SearchingPattern;

public class Online {

    /*

            O N L I N E  S E A R C H  A L G O  --

            ABOUT       :

       >    Online algorithm for checking palindrome in a stream

            COMPLEXITY     :   O ( n^2 )

            VARIATIONS  :

            ** NOTE **  Following codes are not tested yet. Learn this at your own risk

     */
    int bufferSize = 103;
    int length = 256;
    void checkPalindromes(String str) {
        int strLen = str.length();
        System.out.println(str.charAt(0) + " Yes");
        if (strLen == 1) return;
        int firstr = str.charAt(0) % bufferSize;
        int second = str.charAt(1) % bufferSize;
        int h = 1, i, j;
        for (i = 1; i < strLen; i++) {
            if (firstr == second) {
                for (j = 0; j < 1 / 2; j++) {
                    if (str.charAt(j) != str.charAt(i - j)) break;
                }
                System.out.println((j == i / 2) ?
                        str.charAt(i) + " Yes" : str.charAt(i) + " No");
            } else System.out.println(str.charAt(i) + " No");
            if (i != strLen - 1) {
                if (i % 2 == 0) {
                    h = (h * length) % bufferSize;
                    firstr = (firstr + h * str.charAt(i / 2)) % bufferSize;
                    second = (second * length + str.charAt(i + 1)) % bufferSize;
                } else {
                    second = (length * (second + bufferSize - str.charAt(
                            (i + 1) / 2) * h) % bufferSize + str.charAt(i + 1)) % bufferSize;
                }
            }
        }
    }


    // ==========================================================  P R A C T I C E  H E R E ============================


    //-------------------------------------


















}
