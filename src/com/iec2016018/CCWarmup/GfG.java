package com.iec2016018.CCWarmup;

public class GfG {

    public static int V = 4;

    // union find algo

    static void printEgytian(int nr, int dr){

        if (dr == 0 || nr == 0){
            return;
        }

        if (dr % nr == 0){
            System.out.print("1/" + dr / nr);
            return;
        }

        if (nr % dr == 0){
            System.out.print(nr / dr);
            return;
        }

        if (nr > dr){
            System.out.print(nr / dr + " + ");
            printEgytian(nr % dr, dr);
            return;
        }



    }












}
