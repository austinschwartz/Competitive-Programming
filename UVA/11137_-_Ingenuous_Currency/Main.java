import java.util.*;
import java.io.*;

class Main {
    
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String line;
    int[] coins = {9261, 8000, 6859, 5832, 4913, 4096, 3375, 2744, 2197, 1728, 1331, 1000, 729, 512, 343, 216, 125, 64, 27, 8, 1};
    long[] dp = new long[10001];

    dp[0] = 1;
    for (int i = 0; i < 21; i++)
      for (int j = coins[i]; j < 10001; j++) 
        dp[j] += dp[j - coins[i]];

    while (sc.hasNext()) {
      int x = sc.nextInt();
      System.out.println(dp[x]);
    }
  }
}
