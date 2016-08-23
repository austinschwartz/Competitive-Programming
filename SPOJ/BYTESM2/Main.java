import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int R = sc.nextInt();
      int C = sc.nextInt();
      int[][] grid = new int[R][C];
      for (int i = 0; i < R; i++)
        for (int j = 0; j < C; j++)
          grid[i][j] = sc.nextInt();

      int[][] dp = new int[R][C];
      for (int i = 0; i < R; i++)
        Arrays.fill(dp[i], -1);

      for (int i = 0; i < C; i++)
        dp[0][i] = grid[0][i];

      for (int i = 1; i < R; i++) {
        for (int j = 0; j < C; j++) {
          //i-1, j  :  i-1, j-1,   i-1, j+1
          int max = dp[i-1][j];

          if (j-1 >= 0)
            max = Math.max(max, dp[i-1][j-1]);

          if (j+1 < C)
            max = Math.max(max, dp[i-1][j+1]);

          dp[i][j] = max + grid[i][j];

        }
      }

      int m = Integer.MIN_VALUE;
      for (int i = 0; i < C; i++)
        m = Math.max(dp[R-1][i], m);

      out.println(m);
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
