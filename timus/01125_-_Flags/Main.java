import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long[][] dp = new long[46][256];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    for (int i = 0; i < 46; i++)
      Arrays.fill(dp[i], -1);
    int n = sc.nextInt();
    out.println(f(n, 'r') + f(n, 'w'));

    out.close();
  }

  public static long f(int i, char c) {
    if (i == 0) return 0;
    if (dp[i][c] != -1)
      return dp[i][c];

    if (i == 1 && c == 'b') return dp[i][c] = 0;
    if (i == 1) return dp[i][c] = 1;

    if (c == 'w')
      return dp[i][c] = f(i - 1, 'r') + f(i - 2, 'w');

    if (c == 'r')
      return dp[i][c] = f(i - 1, 'w') + f(i - 2, 'r');

    if (c == 'b')
      return dp[i][c] = f(i - 1, 'w') + f(i - 1, 'r');

    return 0;
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
