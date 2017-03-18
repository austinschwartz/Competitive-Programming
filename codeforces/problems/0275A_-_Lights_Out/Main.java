import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int[][] grid = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int k = sc.nextInt();
        grid[i][j] += k;
        if (!oob(i - 1, j)) grid[i - 1][j] += k;
        if (!oob(i + 1, j)) grid[i + 1][j] += k;
        if (!oob(i, j - 1)) grid[i][j - 1] += k;
        if (!oob(i, j + 1)) grid[i][j + 1] += k;
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        out.print((grid[i][j] + 1) % 2);
      }
        out.println();
    }

    out.close();
  }

  public static boolean oob(int i, int j) {
    if (i >= 0 && j >= 0 && i < 3 && j < 3)
      return false;
    return true;
  }

  public static void press(boolean[][] grid, int i, int j, int k) {
    if (k == 0) return;


    press(grid, i, j, k - 1);
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
