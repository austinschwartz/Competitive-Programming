import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int t;
  public static int[] a, coins = {5, 10, 20, 50, 100, 200};
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      a = new int[6];
      a[0] = sc.nextInt(); a[1] = sc.nextInt();
      a[2] = sc.nextInt(); a[3] = sc.nextInt();
      a[4] = sc.nextInt(); a[5] = sc.nextInt();

      if (a[0] == 0 && a[1] == 0 && a[2] == 0 &&
          a[3] == 0 && a[4] == 0 && a[5] == 0)
        break;
      dp = new int[9999][6];
      for (int i = 0; i < 9999; i++)
        Arrays.fill(dp[i], -1);
      t = (int)Math.round(100 * Double.parseDouble(sc.next()));
      out.println(min(t, 0));
    }
    out.close();
  }

  public static int min(int n, int i) {
    if (n == 0) return 0;
    if (i >= 6) return (int)1e9;
    if (dp[n][i] != -1) return dp[n][i];
    int ans = (int)1e9;
    for (int j = 0; j <= a[i] && j * coins[i] <= n; j++) {
      ans = Math.min(ans, j + min(n - j*coins[i], i + 1));
    }
    return dp[n][i] = ans;

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
