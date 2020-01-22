package com.iec2016018.CCWarmup;

import java.io.*;

public class Main {

    private static Main anInstance = null;

    public static Main getInstance() throws IOException {
        InputStreamReader s = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(s);
        bf.read();
        if (anInstance == null){
            anInstance = new Main();
        }
        return anInstance;
    }

    private static String input = "1\n" +
            "4 5\n" +
            "geek gesek";


    public static void main(String[] args) throws IOException {

        StringReader s = new StringReader(input);
        BufferedReader bf = new BufferedReader(s);

        //InputStreamReader stream = new InputStreamReader(System.in);
        //BufferedReader bf = new BufferedReader(stream);
        int t = Integer.parseInt(bf.readLine());
        while(t-->0){
            //code
            String[] lengths = bf.readLine().split(" ");
            int fromLength = Integer.parseInt(lengths[0].replace(" ", ""));
            int toLength = Integer.parseInt(lengths[1].replace(" ", ""));
            String names = bf.readLine();

            char[] from = new char[Math.max(fromLength, toLength)];
            char[] to = new char[Math.max(fromLength, toLength)];
            for (int i = 0 ; i < fromLength ; i++)
                from[i] = names.charAt(i);
            for(int i = fromLength+1 ; i < toLength ; i++)
                to[i-fromLength-1] = names.charAt(i);



        }
        int c = ' ';
        System.out.println(c);

    }






}















