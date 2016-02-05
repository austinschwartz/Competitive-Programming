import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, K;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    dp = new long[1000][1000];
    for (int i = 0; i < 1000; i++)
      for (int j = 0; j < 1000; j++)
        dp[i][j] = -1;

    while ((N = sc.nextInt()) >= 0 &&
           (K = sc.nextInt()) >= 0 &&
            !(N == 0 && K == 0)) {
      out.println(ways2(N, K));
    }
    out.close();
  }

  public static long[][] dp;
  public static long ways2(int N, int K) {
    if (K == 1 || N == 0) return 1;
    if (dp[N][K] != -1)
      return dp[N][K];

    long res = 0;
    for (int i = 0; i <= N; i++)
      res = (res + ways2(N - i, K - 1)) % 1000000;
    dp[N][K] = res;

    return res;
  }

  public static long ways1(int N, int K) {
    if (K == 0) return 0;
    if (K == 1) return 1;
    long res = 0;
    for (int i = 0; i <= N; i++)
      res += ways1(N-i,K-1);
    return res;
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
