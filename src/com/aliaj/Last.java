package com.aliaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by alitsiya.yusupova on 11/1/16.
 */
public class Last {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("win.in"));
        try {
            int time = 300 * 60;
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            String ex = br.readLine();
            System.out.println(ex);
            String[] ary = ex.split("\\s+");
            int[] data = new int[n];
            for (int i=0;i<n;i++){
                data[i] = Integer.parseInt(ary[i]);
            }
            Arrays.sort(data);

            int currentTime = 0;
            int counter = 0;
            for (int i=0;i<n;i++){
                if (currentTime + data[i] > time) {
                    break;
                }
                else {
                    currentTime += data[i];
                    counter++;
                    System.out.println("Added " + data[i]);
                }
            }

            int res = counter;

            System.out.println(res);
            PrintWriter writer = new PrintWriter("win.out", "UTF-8");
            writer.println(res);
            writer.close();
        } finally {
            br.close();
        }
    }
}
