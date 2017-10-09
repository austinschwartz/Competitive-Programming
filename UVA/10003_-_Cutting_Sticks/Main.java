import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static int[] c;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int l = sc.nextInt();
      if (l == 0) break;
      n = sc.nextInt();
      n += 2;
      c = new int[n];
      dp = new int[n][n];
      for (int i = 0; i < n; i++)
        Arrays.fill(dp[i], -1);
      c[0] = 0;
      c[n-1] = l;
      for (int i = 1; i < n - 1; i++)
        c[i] = sc.nextInt();

      out.println(String.format("The minimum cutting is %d.", f(0, n-1)));

    }
    out.close();
  }

  public static int f(int l, int r) {
    if (l + 1 == r)
      return 0;
    if (dp[l][r] != -1)
      return dp[l][r];
    int ans = 0x3f3f3f3f;
    for (int i = l + 1; i < r; i++)
      ans = Math.min(ans, c[r] - c[l] + f(l, i) + f(i, r));
    dp[l][r] = ans;
    return dp[l][r];
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
