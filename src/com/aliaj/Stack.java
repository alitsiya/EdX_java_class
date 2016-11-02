package com.aliaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by alitsiya.yusupova on 11/2/16.
 */
public class Stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("stack.in"));
        try {
            String number = br.readLine();

            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> popped = new ArrayList<Integer>();

            for (int i=0;i<Integer.parseInt(number);i++) {
                String line = br.readLine();
//                String[] ary = line.split("\\s+");
                if (Objects.equals(line.substring(0,1), "+")) {
                    list.add(Integer.parseInt(line.substring(2)));
                } else if (Objects.equals(line.substring(0,1), "-")) {
                    int size = list.size() - 1;
                    int p = list.remove(size);
                    popped.add(p);
                }
            }
            PrintWriter writer = new PrintWriter("stack.out", "UTF-8");
            StringBuilder out = new StringBuilder("");
            System.out.print(out.toString());
            for (Integer s : popped) {
                out.append(s.toString() + "\n");
            }
            writer.println(out);
            writer.close();
        } finally {
            br.close();
        }
    }
}
