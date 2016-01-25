import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static Mark[][] grid;
  public static int R, C, M, N;
  public enum Mark { UNMARKED, VISITING, WATER, EVEN, ODD };

  public static boolean reachable(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] != Mark.UNMARKED)
      return false;
    return true;
  }

  public static int dfs(int r, int c) {
    if (!reachable(r, c)) return 0;
    grid[r][c] = Mark.VISITING;
    int count = 0;
    if (reachable(r - M, c - N)) count++;
    if (reachable(r + M, c + N)) count++;
    if (reachable(r - M, c + N)) count++;
    if (reachable(r + M, c - N)) count++;

    if (reachable(r - N, c - M)) count++;
    if (reachable(r + N, c + M)) count++;
    if (reachable(r - N, c + M)) count++;
    if (reachable(r + N, c - M)) count++;
    grid[r][c] = Mark.UNMARKED;
    return count;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      R = sc.nextInt();
      C = sc.nextInt();
      grid = new Mark[R][C];
      for (int j = 0; j < R; j++)
        Arrays.fill(grid[j], Mark.UNMARKED);
      M = sc.nextInt();
      N = sc.nextInt();
      int W = sc.nextInt();
      for (int j = 0; j < W; j++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        grid[x][y] = Mark.WATER;
      }

      int even = 0;
      int odd = 0;
      for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
          if (grid[r][c] == Mark.UNMARKED) {
            int deeeffss = dfs(r, c);
            if (deeeffss % 2 != 0)
              odd++;
            else
              even++;
          }
        }
      }

      System.out.println("Case " + (i + 1) + ": " + even + " " + odd);
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
