import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, m, sum, min;
  public static int[] coins;
  public static int[][] dp;

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    N = sc.nextInt();
    dp = new int[102][50001];
    for (int n = 0; n < N; n++) {
      m = sc.nextInt();
      sum = 0;

      coins = new int[102];
      for (int j = 1; j <= m; j++) {
        coins[j] = sc.nextInt();
        sum += coins[j];
      }

      int W = sum/2;

      for (int w = 0; w <= W; w++)
        dp[0][w] = 0;

      for (int i = 1; i <= m; i++)
        for (int w = 0; w <= W; w++)
          if (coins[i] <= w)
            dp[i][w] = Math.max(dp[i-1][w], coins[i] + dp[i-1][w - coins[i]]);
          else
            dp[i][w] = dp[i-1][w];


      out.println(sum - 2 * dp[m][W]);
    }
    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;
      } catch (IOException e) {
        return false;
      }
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char nextChar() {
      return next().charAt(0);
    }

    public String nextLine() {
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
