import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int M, N;
  public static int[][] grid, dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      if (N == 0 && M == 0)
        break;

      grid = new int[N][M];
      for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
          grid[i][j] = (sc.nextChar() == '1' ? 0 : 1);

      for (int i = 1; i < N; i++)
        for (int j = 0; j < M; j++)
          if (grid[i][j] == 1)
            grid[i][j] = grid[i - 1][j] + 1;

      int max = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          int cur = grid[i][j];
          for (int k = j + 1; k < M && grid[i][j] <= grid[i][k]; k++)
            cur += grid[i][j];
          for (int k = j - 1; k >= 0 && grid[i][j] <= grid[i][k]; k--)
            cur += grid[i][j];
          max = Math.max(max, cur);
        }
      }

      out.println(max);
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
