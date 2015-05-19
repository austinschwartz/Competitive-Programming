import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      int[] map = new int[256];
      char[] chars = line.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        map[chars[i]] += 1;
      }
      int max = 0;
      for (int j = 0; j < 256; j++) {
        if ((j >= 'A' && j <= 'Z') || (j >= 'a' && j <= 'z')) {
          if (map[j] > max)
            max = map[j];
        }
      }
      ArrayList<Character> results = new ArrayList<Character>();
      for (int k = 0; k < 256; k++) {
        if (map[k] == max) {
          if ((k >= 'A' && k <= 'Z') || (k >= 'a' && k <= 'z')) {
            results.add((char)k);
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int l = 0; l < results.size(); l++) {
        sb.append(results.get(l));
      }
      System.out.println(sb.toString() + " " + max);
    }
  }
}
