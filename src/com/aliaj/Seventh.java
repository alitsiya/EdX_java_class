package com.aliaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alitsiya.yusupova on 10/26/16.
 */
public class Seventh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("testgen.in"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int N = 0;
            if (!line.isEmpty()) {N = Integer.parseInt(line);}
            int[] dev = new int[N];
            dev[0] = 0;
            dev[1] = 1; //1
            dev[2] = 2; //2,1
            //3 - 2
            //4 - 3
            //5 - 2
            //6 - 3  - 3,2,1

            int res = 0;
            if (N == 0) {res = 0;}
            else if (N == 1) {res = 1;}
            else if (N==2) {res = 2;}
            else {
            for (int i=3;i<N;i++) {
                int localdev = 0;
                for(int j=i-1;j>1;j--){
                    if (i%j ==0) {
                        localdev = dev[j] + dev[i/j];
                        System.out.println();
                    }
                }
            }}
            PrintWriter writer = new PrintWriter("testgen.out", "UTF-8");
            writer.println(res);
            writer.close();
            }
        finally {
                br.close();
        }
    }
}
