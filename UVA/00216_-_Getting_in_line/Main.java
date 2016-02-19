import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static double[][] dist;
  public static int[] x, y;
  public static int maxMask, lastMask;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = 1;
    while (true) {
      n = sc.nextInt();
      if (n == 0)
        break;
      maxMask = (1 << n) - 1;
      dist = new double[n][n];
      x = new int[n];
      y = new int[n];
      for (int i = 0; i < n; i++)  {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      dp      = new double[n][1 << n];
      parent     = new int[n][1 << n];
      bestParent = new int[n][1 << n];

      for (int i = 0; i < dp.length; i++)
        Arrays.fill(dp[i], -1);

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          double d = ed(i, j);
          dist[i][j] = d;
          dist[j][i] = d;
        }
      }

      double min = Double.MAX_VALUE, curr = 0.0;
      int best = 0;

      for (int i = 0; i < n; i++) {
        curr = tsp(i, 1 << i);
        if (curr < min) {
          min = curr;
          best = i;
          for (int j = 0; j < n; j++) {
            for (int k = 0; k < bestParent[0].length; k++) {
              bestParent[j][k] = parent[j][k];
            }
          }
        }
      }

      out.println("**********************************************************");
      out.printf("Network #%d\n", t++);
      int bitmask = 1 << best;
      for (int i = 0; i < n - 1; i++) {
        int adj = parent[best][bitmask];

        out.printf("Cable requirement to connect (%d,%d) to (%d,%d) is %.02f feet.\n", x[best], y[best], x[adj], y[adj], dist[best][adj]);
        bitmask |= 1 << adj;

        best = adj;
      }
      out.printf("Number of feet of cable required is %.02f.\n", min);

    }
    out.close();
  }

  public static double[][] dp;
  public static int[][] parent, bestParent;

  public static double tsp(int pos, int mask) {
    if (mask == (1 << n) - 1)
      return 0;

    if (dp[pos][mask] != -1.0)
      return dp[pos][mask];

    double ret = Double.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (i != pos && (mask & (1 << i)) == 0) {
        double result = dist[pos][i] + tsp(i, mask | (1 << i)); 
        if (result < ret) {
          ret = result;
          parent[pos][mask] = i;
        }
      }
    }
    return dp[pos][mask] = ret;
  }

  public static double ed(int i, int j) {
    return Math.sqrt(Math.pow(x[j] - x[i], 2) +
                     Math.pow(y[j] - y[i], 2)) + 16.0;
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
