import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N = Integer.parseInt(br.readLine());
    br.readLine();
    for (int i = 0; i < N; i++) {
      Map<String, Integer> map = new TreeMap<String, Integer>();
      int count = 0;
      line = br.readLine();
      while (line != null && line.length() > 0) {
        if (map.containsKey(line))
          map.put(line, map.get(line) + 1);
        else
          map.put(line, 1);
        count++;
        line = br.readLine();
      }
      for (String key : map.keySet()) {
        String percent = String.format("%.4f", ((map.get(key) / (double)count) * 100));
        System.out.println(key + " " + percent);
      }
      if (i < N - 1)
        System.out.println();
    }
  }
}
