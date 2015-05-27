import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      String[] arr = br.readLine().split(" ");
      int N = Integer.parseInt(arr[0]);
      int M = Integer.parseInt(arr[1]);
      String[] Ns = br.readLine().split(" ");
      String[] Ms = br.readLine().split(" ");
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int j = 0; j < N; j++) {
        int x1 = Integer.parseInt(Ns[j]);
        if (map.containsKey(x1))
          map.put(x1, map.get(x1) + 1);
        else
          map.put(x1, 1);
      }
      for (int k = 0; k < M; k++) {
        int x2 = Integer.parseInt(Ms[k]);
        if (map.containsKey(x2))
          map.put(x2, map.get(x2) - 1);
        else
          map.put(x2, -1);
      }
      int count = 0;
      for (int key : map.keySet())
        count += Math.abs(map.get(key));
      System.out.println(count);
    }
  }
}
