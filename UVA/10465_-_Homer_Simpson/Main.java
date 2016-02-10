import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int m, n, t;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      m = sc.nextInt();
      n = sc.nextInt();
      t = sc.nextInt();
      int[] dp = new int[12000];
      if (m > n) {
        int temp = m;
        m = n;
        n = temp;
      }
      dp[m] = 1;
      dp[n] = 1;
      for (int i = m; i <= t; i++) {
        if (dp[i] > 0) {
          if (i + m <= t) dp[i + m] = Math.max(dp[i + m], dp[i] + 1);
          if (i + n <= t) dp[i + n] = Math.max(dp[i + n], dp[i] + 1);
        }
      }
      if (dp[t] > 0)
        out.println(dp[t]);
      else {
        boolean printed = false;
        for (int i = t - 1; i >= 0 && !printed; i--) {
          if (dp[i] > 0) {
            out.printf("%d %d\n", dp[i], t - i);
            printed = true;
          }
        }
        if (!printed)
          out.printf("0 %d\n", t);
      }
    }
    out.close();
  }

  public static int burg(int i) {
    if (i <= 0) return 0;
    return 1 + Math.max(burg(i - m), burg(i - n));
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
