import java.util.*;
import java.io.*;

class Solution {
  public static long[][] table;
  public static long maxCoins(int[] coins, int N, int M) {
    if (N < 0) return 0;
    if (N >= 1 && M <= 0) {
      if (M == 0) table[N][M] = 0;
      return 0;
    }
    if (table[N][M] != -1) return table[N][M];
    table[N][M] = maxCoins(coins, N - coins[M-1], M) +
           maxCoins(coins, N, M-1);
    return table[N][M];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);
    int[] coins = new int[M];
    table = new long[N + 1][M + 1];
    for (int i = 0; i < N + 1; i++)
      Arrays.fill(table[i], -1);

    for (int i = 0; i < M + 1; i++)
      table[0][i] = 1;

    s = br.readLine().split(" ");
    for (int i = 0; i < M; i++) {
      coins[i] = Integer.parseInt(s[i]);
    }
    System.out.println(maxCoins(coins, N, M));
  }
}
