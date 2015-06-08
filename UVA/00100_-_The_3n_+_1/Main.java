import java.util.*;
import java.io.*;

class Main {
  public static int recurse(int i, int n) {
    if (i == 1)
      return n;
    else if (i % 2 == 0)
      return recurse(i / 2, n+1);
    else
      return recurse((3 * i) + 1, n+1);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      StringTokenizer stk = new StringTokenizer(line);
      int i = Integer.parseInt(stk.nextToken());
      int j = Integer.parseInt(stk.nextToken());
      int maxCycle = -1;
      for (int k = Math.min(i, j); k <= Math.max(i, j); k++) {
        int r = recurse(k, 1);
        if (r > maxCycle)
          maxCycle = r;
      }
      System.out.println(i + " " + j + " " + maxCycle);
    }
  }
}
