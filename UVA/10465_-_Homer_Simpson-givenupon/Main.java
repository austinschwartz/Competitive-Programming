import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null && !line.equals("")) {
      String[] sp = line.split(" ");
      int m = Integer.parseInt(sp[0]);
      int n = Integer.parseInt(sp[1]);
      int t = Integer.parseInt(sp[2]);
      int[] dp = new int[t + 1];
      Arrays.fill(dp, 0);
      if (m <= t)
        dp[m] = 1;
      if (n <= t)
        dp[n] = 1;
      if (m > n) {
        int temp = m;
        m = n;
        n = temp;
      }
      // m = smaller burger time, n = larger burger time
      for (int i = m; i <= t; i++) {
        if (dp[i] != 0) {
          if (i + m <= t) dp[i + m] = Math.max(dp[i + m], dp[i] + 1);
          if (i + n <= t) dp[i + n] = Math.max(dp[i + n], dp[i] + 1);
        }
      }
      if (dp[t] != -1) {
        System.out.println(dp[t]);
      } else {
      }
    }
  }
}
