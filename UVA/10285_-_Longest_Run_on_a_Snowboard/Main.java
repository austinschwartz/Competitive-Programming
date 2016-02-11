import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static String S;
  public static int R, C;
  public static int[][] slopes, dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      S = sc.next();
      R = sc.nextInt();
      C = sc.nextInt();
      slopes = new int[R][C];
      dp = new int[R][C];
      for (int j = 0; j < R; j++)
        for (int k = 0; k < C; k++)
          slopes[j][k] = sc.nextInt();

      int max = 0;
      for (int j = 0; j < R; j++) {
        for (int k = 0; k < C; k++) {
          for (int l = 0; l < R; l++)
            Arrays.fill(dp[l], -1);
          max = Math.max(max, lis(j, k));
        }
      }

      out.printf("%s: %d\n", S, max);

    }
    out.close();
  }

  public static boolean reachable(int i, int j) {
    if (i < 0 || i >= R || j < 0 || j >= C)
      return false;
    return true;
  }

  public static int[][] coords = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static int lis(int i, int j) {
    if (dp[i][j] != -1)
      return dp[i][j];
    int max = 1;
    for (int[] coord : coords) {
      int ni = i + coord[0];
      int nj = j + coord[1];
      if (reachable(ni, nj) && 
          slopes[i][j] > slopes[ni][nj])
        max = Math.max(max, 1 + lis(ni, nj));
    }
    dp[i][j] = max;
    return max;
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
