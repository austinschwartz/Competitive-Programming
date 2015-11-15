import java.util.*;
import java.io.*;

class Main {
  public static int[] coins = new int[22];
  public static long[][] dp;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    for (int i = 1; i <= 21; i++) {
      coins[i-1] = (int)Math.pow(i, 3);
    }

    dp = new long[10001][22];
    for (int i = 0; i < 22; i++)
      Arrays.fill(dp[i], 0);

    for (int i = 0; i < 22; i++)
      dp[0][i] = 1;

    for (int i = 1; i < 10001; i++) {
      for (int j = 0; j < 22; j++) {
        long x = j >= 1 ? dp[i][j - 1] : 0;
        long y = i - coins[j] >= 0 ? dp[i - coins[j]][j] : 0;
        dp[i][j] = x + y;
      }
    }

    while ((line = br.readLine()) != null && !line.equals("")) {
      int n = Integer.parseInt(line);
      System.out.println(dp[n][21]);
    }
  }
}
