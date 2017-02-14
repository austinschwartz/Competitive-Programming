import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;

  static long[] dp = new long[46];
  static {
    Arrays.fill(dp, -1);
    dp[0] = 0;
    dp[1] = 2;
    dp[2] = 2;
  }
  public static long f(int N) {
    if (dp[N] != -1) return dp[N];
    return dp[N] = f(N - 1) + f(N - 2);
  }

  /*
   * m = f(n) = f(n-1)  + f(n-2)
   *
   * why f(n-1) :-
   * put W and [R,...(n-1)] or R and [W,...(n-1)]
   *
   * why f(n-2) :-
   * put R,B and [W,..(n-2)] or W,B and [R,...(n-2)]
   */

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();
    out.println(f(N));
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
