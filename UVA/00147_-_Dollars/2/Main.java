import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] coins = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };
  public static long[][] dp;
  public static int MAXN = coins.length, MAXX = 100000;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    dp = new long[MAXN + 1][MAXX + 1];
    for (int i = 0; i < dp.length; i++)
      Arrays.fill(dp[i], -1);
    while (sc.hasNext()) {
      String[] line = sc.nextLine().split("\\.");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      int x = (a * 100) + b;
      if (x == 0)
        break;
      out.printf("%3d.%02d%17d\n", a, b, c(0, x));
    }
    out.close();
  }

  public static long c(int i, int x) {
    if (x <  0) return 0;
    if (x == 0) return 1;

    if (dp[i][x] != -1)
      return dp[i][x];
   
    if (i == coins.length)
      return dp[i][x] = 0;

    return dp[i][x] = c(i + 1, x) + c(i, x - coins[i]);
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
