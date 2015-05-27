import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {
      int n = in.nextInt();
      if (n == 0)
        break;
      int total = 0;
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < n; i++) {
        int k = in.nextInt();
        for (int j = 0; j < k; j++) {
          int x = in.nextInt();
          if (map.containsKey(x))
            map.put(x, map.get(x) + 1);
          else
            map.put(x, 1);
        }
        int low = Integer.MAX_VALUE;
        int high = -1;
        for (int s : map.keySet()) {
          if (map.get(s) > 0) {
            if (s < low)
              low = s;
            if (s > high)
              high = s;
          }
        }
        total += (high - low);
        if (map.containsKey(high))
          map.put(high, map.get(high) - 1);
        else
          map.remove(high);
        if (map.containsKey(low))
          map.put(low, map.get(low) - 1);
        else
          map.remove(low);

      }
      System.out.println(total);
    }
  }
}
