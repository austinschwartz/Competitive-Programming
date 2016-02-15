import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] coins = {50, 25, 10, 5, 1};
  public static int n;
  public static long[] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    dp = new long[30001];
    dp[0] = 1;
    for (int i = 0; i < 5; i++)
      for (int j = coins[i]; j <= 30000; j++)
        dp[j] += dp[j - coins[i]];

    while (sc.hasNext()) {
      n = sc.nextInt();
      if (dp[n] == 1)
        out.printf("There is only %d way to produce %d cents change.\n", dp[n], n);
      else
        out.printf("There are %d ways to produce %d cents change.\n", dp[n], n);
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
