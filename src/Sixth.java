import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by alitsiya.yusupova on 10/25/16.
 */
public class Sixth {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("template.in"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            String[] ary = line.split("\\s+");
            int h = Integer.parseInt(ary[0]);
            int w = Integer.parseInt(ary[1]);
            String[][] keyboard = new String[w][h];
            for (int i=0;i<w;i++){
                line = br.readLine();
                String[] newline = line.split("");
                keyboard[i] = newline;
                System.out.println(line);
            }

            StringBuilder codesb = new StringBuilder();
            String currentLanguage = "";
//            HashMap<String, String> hmap = new HashMap<String, String>();

            List<String[]> resList = new ArrayList<String[]>();

            line = br.readLine();
            while (line != null) {
                if (line.equals("")) {
                    if (!Objects.equals(currentLanguage, "")){
                        if (codesb != null) {
                            String[] langCode = new String[2];
                            langCode[0] = currentLanguage;
                            langCode[1] = codesb.toString();
                            resList.add(langCode);
                        }
                        codesb = new StringBuilder();
                        currentLanguage="";
                    }
                    line = br.readLine();
                    currentLanguage = line;
                }
                else {
                    codesb.append(line);
                }
                line = br.readLine();
            }

            if (codesb != null) {
                String[] langCode = new String[2];
                langCode[0] = currentLanguage;
                langCode[1] = codesb.toString();
                resList.add(langCode);
            }
            System.out.println("Result list");
            System.out.println(resList);

            HashMap<String, int[]> keyboardmap;
            keyboardmap = converttomap(keyboard);
            for (String key : keyboardmap.keySet()) {
                System.out.println("Key = " + key + ", value = " + Integer.toString(keyboardmap.get(key)[0]));
            }
            System.out.println("Size " + Integer.toString(keyboardmap.size()));
            List<String[]> cmap = new ArrayList<String[]>();
            for (int x=0;x<resList.size();x++){
                String letters = resList.get(x)[1];
                Integer localres = 0;
                for (int i = 0; i < letters.length()-1; i++) {
                    char c = letters.charAt(i);
                    char d = letters.charAt(i+1);
                    System.out.println("Character 1:" + c);
                    System.out.println("Character 2:" + d);
                    int[] loc = keyboardmap.get(Character.toString(c));
                    int[] lod = keyboardmap.get(Character.toString(d));
                    System.out.println(Integer.toString(loc[0]));
                    System.out.println(Integer.toString(lod[0]));
                    int diff = Math.max(Math.abs(loc[0] - lod[0]), Math.abs(loc[1] - lod[1]));
                    localres += diff;
                }
                String[] temphold = new String[2];
                temphold[0] = resList.get(x)[0];
                temphold[1] = localres.toString();
                cmap.add(temphold);
                localres = 0;
            }
            System.out.println(cmap);
            Integer localmax = 100000000;
            String name = "";
            for (int y=0;y<cmap.size();y++) {
                Integer val = Integer.parseInt(cmap.get(y)[1]);
                if (val < localmax) {
                    localmax = val;
                    name = cmap.get(y)[0];
                }
            }
            System.out.println(name);

            String res = name;
            PrintWriter writer = new PrintWriter("template.out", "UTF-8");
            writer.println(res);
            writer.println(localmax);
            writer.close();
        } finally {
            br.close();
        }
    }

    public static HashMap<String, int[]> converttomap(String[][] keyboard) {
        HashMap<String, int[]> res = new HashMap<>();
        for (int i=0;i<keyboard.length;i++){
            for (int j=0;j<keyboard[i].length;j++){
                int[] temp = new int[2];
                temp[0] = 9 - i;
                temp[1] = j + 1;
                res.put(keyboard[i][j], temp);
            }
        }

        return res;
    }
}