
package com.aliaj;

/**
 * The HelloWorldApp class implements an application that
 * simply prints "Hello World!" to standard output.
 */

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("aplusb.in"));
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
            int res = 0;
            for (int i=0; i<ary.length; i++){
                res = res + Integer.parseInt(ary[i]);
            }
            PrintWriter writer = new PrintWriter("aplusb.out", "UTF-8");
            writer.println(res);
            writer.close();
        } finally {
            br.close();
        }
    }
}