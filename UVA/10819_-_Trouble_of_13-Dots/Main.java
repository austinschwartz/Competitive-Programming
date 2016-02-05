import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int m, n;
  public static int[] F, P;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      m = sc.nextInt();
      n = sc.nextInt();
      F = new int[n];
      P = new int[n];
      for (int i = 0; i < n; i++) {
        P[i] = sc.nextInt();
        F[i] = sc.nextInt();
      }

      dp = new int[1000][15001];
      for (int i = 0; i < 1000; i++)
        Arrays.fill(dp[i], -1);

      out.println(f(0, 0));
    }
    out.close();
  }

  public static int SMALLNUM = -1000;

  public static int f(int i, int c) {
    if (c > m && m < 1800)
      return SMALLNUM;
    if (c - 200 > m)
      return SMALLNUM;
    if (i == n)
      if (c <= 2000 && c > m)
        return SMALLNUM;
      else
        return 0;

    if (dp[i][c] == -1)
      dp[i][c] = Math.max(f(i + 1, c), F[i] + f(i + 1, c + P[i]));

    return dp[i][c];

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
          return null;
        }
      }
      return st.nextToken();
    }
 
    public Integer nextInt() {
      String next = next();
      if (next == null)
        return null;
      else
        return Integer.parseInt(next);
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
