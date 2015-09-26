import java.util.*;
import java.io.*;

class Main {
  public static int[][] memo;
  public static int[] coins = new int[]{1, 5, 10, 25, 50};
  public static int change(int n, int m) {
    if (n == 1 || n == 0) return 1;
    if (n < 0) return 0;
    if (m <= 0 && n >= 1) return 0;
    if (memo[n][m] != -1) return memo[n][m];

    memo[n][m] = change(n, m-1) + change(n - coins[m-1], m);
    return memo[n][m];
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    memo = new int[100000][6];
    for (int i = 0; i < 100000; i++)
      Arrays.fill(memo[i], -1);
    memo[0][5] = 1;
    memo[1][5] = 1;
    while ((line = br.readLine()) != null) {
      System.out.println(change(Integer.parseInt(line), 5));
    }
  }
}
