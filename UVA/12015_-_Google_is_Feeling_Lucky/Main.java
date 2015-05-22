import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 1; i <= T; i++) {
      int max = -1;
      Map<String, Integer> map = new LinkedHashMap<String, Integer>();
      for (int j = 0; j < 10; j++) {
        String[] arr = br.readLine().split(" ");
        String url = arr[0];
        int rank = Integer.parseInt(arr[1]);
        max = Math.max(max, rank);
        map.put(url, rank);
      }
      System.out.println("Case #" + i + ":");
      for (String key : map.keySet())
        if (map.get(key) == max)
          System.out.println(key);
    }
  }
}
