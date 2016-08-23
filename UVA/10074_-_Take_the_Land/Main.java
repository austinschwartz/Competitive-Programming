import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int M, N;
  public static boolean[][] grid;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while ((M = sc.nextInt()) >= 0 &&
           (N = sc.nextInt()) >= 0 &&
           !(M == 0 && N == 0)) {
      grid = new boolean[M][N];
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          char c = sc.nextChar();
          grid[i][j]= (c == '1' ? true : false);
        }
      }
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++)
          out.print(grid[i][j] ? '1' : '0');
        out.println();
      }

      dp = new int[M][N];
      for (int i = 0; i < M; i++)
        Arrays.fill(dp[i], -1);

      for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
          dp[i][j] = f(i, j);

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++)
          out.print(dp[i][j] + "  " );
        out.println();
      }
    }
    out.close();
  }

  public static int f(int i, int j) {
    if (dp[i][j] != -1)
      return dp[i][j];

    if (grid[i][j])
      return 0;
    if (i == 0 && j == 0)
      return (grid[i][j] ? 0 : 1);
    if (i == 0)
      return 1 + f(i, j-1);
    if (j == 0)
      return 1 + f(i-1, j);
    if (grid[i-1][j])
      return f(i, j-1) - f(i-1, j-1);


    return 1;
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
