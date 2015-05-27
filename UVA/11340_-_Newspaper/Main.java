import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int worth = 0;
      int K = Integer.parseInt(br.readLine());
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (int j = 0; j < K; j++) {
        String[] arr = br.readLine().split(" ");
        map.put(arr[0].charAt(0), Integer.parseInt(arr[1]));
      }
      int M = Integer.parseInt(br.readLine());
      for (int k = 0; k < M; k++) {
        line = br.readLine();
        for (char a : line.toCharArray())
          if (map.containsKey(a))
            worth += map.get(a);
      }
      System.out.printf("%d.%02d$\n", worth / 100, worth % 100);
    }
  }
}
