package com.aliaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alitsiya.yusupova on 11/1/16.
 */
public class Prelast {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("testgen.in"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int num = Integer.parseInt(line);

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(2);
            list.add(3);

            int n=4;
            while (n <= num) {
                boolean isPrime = true;
                for (int i=0;i<list.size();i++){
                    if (n%list.get(i) == 0){
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime){
                    list.add(n);
                }
                else {isPrime = true;}
                n++;
            }

            int localmax = 0;
            int maxpos = 0;
            int tempres;
            for (int i=1;i<=num;i++){
                tempres = calculate(list, i);
                System.out.println("Number of divisors for "+i+" is "+ tempres);
                if (tempres > localmax){
                    localmax = tempres;
                    maxpos = i;
                }
            }
            System.out.println("Max divisors num is "+localmax + " in position " + maxpos);
            int res = num - maxpos + 1;
            System.out.println(res);
            PrintWriter writer = new PrintWriter("testgen.out", "UTF-8");
            writer.println(res);
            writer.close();
        } finally {
            br.close();
        }
    }

    public static int calculate(ArrayList<Integer> list, int number){
        int res = 1;
        int i = 0;
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        int temp = list.get(i);
        System.out.println("Current divisor "+temp);
        while (temp <= number){
            if (number%temp == 0){
                divisors.add(temp);
                number = number/temp;
            }
            else {
                i += 1;
                temp = list.get(i);
            }
        }
        for (int k=0;k<divisors.size();k++){
            System.out.print(divisors.get(k) + " ");
        }
        Set<Integer> set = new HashSet<Integer>(divisors);

        for (Integer s : set){
            int occurrences = Collections.frequency(divisors, s);
            res *= (occurrences + 1);
        }
        return res;
    }
}
