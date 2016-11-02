package com.aliaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alitsiya.yusupova on 10/24/16.
 */
public class Second {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("aplusbb.in"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] ary = everything.split("\\s+");
            Long res = Long.parseLong(ary[0]) + Long.parseLong(ary[1])*Long.parseLong(ary[1]);
            System.out.println(res);
            PrintWriter writer = new PrintWriter("aplusbb.out", "UTF-8");
            writer.println(res);
            writer.close();
        } finally {
            br.close();
        }
    }
}