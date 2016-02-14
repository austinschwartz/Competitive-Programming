import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n, k, m;
  public static long[][][] dp = new long[51][51][51];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      n = sc.nextInt();
      k = sc.nextInt();
      m = sc.nextInt();
      for (int i = 0; i <= 50; i++)
        for (int j = 0; j <= 50; j++)
          Arrays.fill(dp[i][j], -1);
      out.println(bc(n, k, m));
    }
    out.close();
  }

  public static long bc(int n, int k, int m) {
    if (k == 0 && n > 0)
      return 0;
    if (k == 0)
      return 1;
    if (dp[n][k][m] != -1)
      return dp[n][k][m];

    long ans = 0;
    for (int i = 1; i <= m; i++)
      if (n >= i)
        ans += bc(n - i, k - 1, m);

    return dp[n][k][m] = ans;
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
