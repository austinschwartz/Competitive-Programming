import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int m = sc.nextInt();
    int n = sc.nextInt();
    char[][] grid = new char[m][n];
    int[][] newGrid = new int[m][n];
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      char[] line = sc.next().toCharArray();
      for (int j = 0; j < n; j++) {
        char x = line[j];
        grid[i][j] = x;
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '*') {
          grid[i][j] = '.';
          newGrid[i][j] = dfs(grid, visited, i, j);
          visited = new boolean[m][n];
          grid[i][j] = '*';
        } else
          newGrid[i][j] = 0;
      }
    }
    

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (newGrid[i][j] == 0)
          System.out.print(".");
        else
          System.out.print(newGrid[i][j]);
      }
      System.out.println();
    }

    out.close();
  }

  public static int dfs(char[][] grid, boolean[][] visited, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n)
      return 0;

    if (visited[i][j])
      return 0;

    visited[i][j] = true;

    if (grid[i][j] == '*')
      return 0;

    int res = 1;
    grid[i][j] = '*';
    res += dfs(grid, visited, i,j+1);
    res += dfs(grid, visited, i,j-1);
    res += dfs(grid, visited, i+1,j);
    res += dfs(grid, visited, i-1,j);
    grid[i][j] = '.';

    return res;

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
