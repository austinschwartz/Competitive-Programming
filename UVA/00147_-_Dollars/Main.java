import java.util.*;
import java.io.*;

class Main {

  
  static long[][] dp;
  static int[] coins = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5};
  
  static long solve(int i, int v) {
    if (v < 0)
      return 0;

    if (dp[i][v] != -1)
      return dp[i][v];

    if (v == 0)
      return dp[i][v] = 1;

    if (i == coins.length)
      return dp[i][v] = 0;
    
    return dp[i][v] = solve(i + 1, v) + solve(i, v - coins[i]);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int MAXN = coins.length;
    int MAXV = 60000;
    
    dp = new long[MAXN + 1][MAXV + 1];
    for (int i = 0; i <= MAXN; ++i)
      Arrays.fill(dp[i], -1);
    
    while (true) {
      double  dV = Double.parseDouble(in.readLine());
      dV *= 100;
      int V = (int)Math.round(dV);
      if (V == 0)
        break;
      System.out.printf("%6.2f%17d\n", ((double)V / 100), solve(0, V));
    }
    
    in.close();
    System.exit(0);
  }
}
