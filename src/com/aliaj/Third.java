package com.aliaj;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Math.abs;

/**
 * Created by alitsiya.yusupova on 10/24/16.
 */
public class Third {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("prepare.in"));
        try {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            String[] t = br.readLine().toString().split("\\s+");
            String[] p = br.readLine().toString().split("\\s+");

            Long res = 0L;
            Boolean isPractical = false;
            Boolean isTheoretical = false;
            int[] diff = new int[n];
            for (int i=0; i<n;i++) {
                int a = Integer.parseInt(t[i]);
                int b = Integer.parseInt(p[i]);
                int m = 0;
                if (a < b) {
                    m = b;
                    isPractical = true;
                }
                else if (a > b) {
                    m = a;
                    isTheoretical = true;
                }
                else {
                    m = a;
                    isPractical = true;
                    isTheoretical = true;
                }
                diff[i] = abs(a-b);
                res += m;
            }
            System.out.println("Before: " + res.toString());
            int mn = diff[0];
            for (int i=0; i<n;i++) {
                mn = diff[i] < mn ? diff[i] : mn;
            }
            if (!isPractical || !isTheoretical) {
                res = res - mn;
            }
            System.out.println("After: " + res.toString());
            PrintWriter writer = new PrintWriter("prepare.out", "UTF-8");
            writer.println(res);
            writer.close();
        } finally {
            br.close();
        }
    }
}
