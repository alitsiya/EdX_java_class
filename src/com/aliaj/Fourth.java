package com.aliaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Math.sqrt;

/**
 * Created by alitsiya.yusupova on 10/24/16.
 */
public class Fourth {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("team.in"));
        try {
            String a0 = br.readLine();
            System.out.println(a0);
            String[] a = a0.split("\\s+");

            String b0 = br.readLine();
            String[] b = b0.split("\\s+");

            String c0 = br.readLine();
            String[] c = c0.split("\\s+");
            double res = 0;

            res = calc(Integer.parseInt(a[0]),Integer.parseInt(b[1]),Integer.parseInt(c[2]), res);
            res = calc(Integer.parseInt(a[0]),Integer.parseInt(b[2]),Integer.parseInt(c[1]), res);
            res = calc(Integer.parseInt(a[1]),Integer.parseInt(b[0]),Integer.parseInt(c[2]), res);
            res = calc(Integer.parseInt(a[1]),Integer.parseInt(b[2]),Integer.parseInt(c[0]), res);
            res = calc(Integer.parseInt(a[2]),Integer.parseInt(b[0]),Integer.parseInt(c[1]), res);
            res = calc(Integer.parseInt(a[2]),Integer.parseInt(b[1]),Integer.parseInt(c[0]), res);

            System.out.println(res);


//            String everything = sb.toString();
//            String[] ary = everything.split("\\s+");
//            Long res = Long.parseLong(ary[0]) + Long.parseLong(ary[1])*Long.parseLong(ary[1]);
//            System.out.println(res);
            PrintWriter writer = new PrintWriter("team.out", "UTF-8");
            writer.println(res);
            writer.close();
        } finally {
            br.close();
        }
    }
    public static double calc(int a, int b, int c, double res) {
        double result = sqrt(a*a + b*b +c*c);
        return result > res ? result : res;
    }
}
