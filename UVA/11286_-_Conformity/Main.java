import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = 0;
    while ((n = Integer.parseInt(br.readLine())) > 0) {
      Map<String, Integer> map = new TreeMap<String, Integer>();
      for (int i = 0; i < n; i++) {
        String[] arr = br.readLine().split(" ");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
          sb.append(arr[j]);
          if (j < arr.length - 1)
            sb.append(" ");
        }
        String str = sb.toString();
        if (map.containsKey(str))
          map.put(str, map.get(str) + 1);
        else
          map.put(str, 1);
      }
      int max = -1;
      for (String key : map.keySet())
        if (map.get(key) > max)
          max = map.get(key);
      int count = 0;
      for (int value : map.values())
        if (value == max)
          count += value;
      System.out.println(count);
    }
  }
}
