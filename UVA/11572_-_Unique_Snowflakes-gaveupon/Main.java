import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < t; i++) {
      Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
      int n = Integer.parseInt(br.readLine().trim());
      int max = 0;
      int current = 0;
      for (int j = 0; j < n; j++) {
        int x = Integer.parseInt(br.readLine().trim());
        if (map.containsKey(x)) {
          current -= map.get(x);
          map = new TreeMap<Integer, Integer>();
          map.put(x, current);
        } else {
          map.put(x, current);
          current++;
        }
        max = Math.max(max, current);
      }
      System.out.println(max);
    }
  }
}
