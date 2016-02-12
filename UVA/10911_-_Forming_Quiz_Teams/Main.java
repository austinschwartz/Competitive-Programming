import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] x, y;
  public static int maxBitmask;
  public static double[] dp;
  public static double[][] dist;
  public static int N, NN;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = 1;
    while (true) {
      N = sc.nextInt();
      if (N == 0)
        break;

      NN = 2 * N;
      dist = new double[NN][NN];
      maxBitmask = (1 << NN) - 1;
      dp = new double[1 << 16];
      x = new int[NN];
      y = new int[NN];
      for (int i = 0; i < NN; i++) {
        sc.next();
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      for (int i = 0; i < NN; i++)
        for (int j = i + 1; j < NN; j++)
          dist[i][j] = dist[j][i] = dist(i, j);

      Arrays.fill(dp, -1);

      out.printf("Case %d: %.2f\n", n++, f(0));
    }
    out.close();
  }

  public static double f(int bitmask) {
    if (bitmask == maxBitmask)
      return 0;

    if (dp[bitmask] != -1)
      return dp[bitmask];

    double ans = 1 << 20;
    for (int i = 0; i < NN; i++) {
      if ((bitmask & (1 << i)) > 0)
        continue;
      for (int j = i + 1; j < NN; j++) {
        if ((bitmask & (1 << j)) > 0)
          continue;
        ans = Math.min(ans, dist[i][j] + f(bitmask | (1 << j) | (1 << i)));
      }
    }
    return dp[bitmask] = ans;
  }

  public static double dist(int i, int j) {
    return Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
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
