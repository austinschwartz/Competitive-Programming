import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt();
      int[][] grid = new int[2 * N][2 * N];
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          int num = sc.nextInt();
          grid[j][k] = num;
          grid[j + N][k] = num;
          grid[j][k + N] = num;
          grid[j + N][k + N] = num;
        }
      }
      out.println(maxSumBetter(grid, N*2));
    }
    out.close();
  }

  public static int maxSumBetter(int[][] matrix, int N) {
    int[][] sat = new int[N][N];
    sat[0][0] = matrix[0][0];
    for (int i = 1; i < N; i++)
      sat[0][i] = matrix[0][i] + sat[0][i-1];
    for (int i = 1; i < N; i++)
      sat[i][0] = matrix[i][0] + sat[i-1][0];

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < N; j++) {
        sat[i][j] = sat[i-1][j]   + sat[i][j-1] - 
                    sat[i-1][j-1] + matrix[i][j];
      }
    }

    int max = -1000000;
    for (int i = 0; i < N/2; i++) {
      for (int j = 0; j < N/2; j++) {
        for (int k = i; k < i + N/2; k++) {
          for (int l = j; l < j + N/2; l++) {
            int cur = sat[k][l];
            if(i > 0) cur -= sat[i - 1][l];
            if(j > 0) cur -= sat[k][j - 1];
            if(i > 0 && j > 0)
                cur += sat[i - 1][j - 1];
            max = Math.max(cur, max);
          }
        }
      }
    }

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
