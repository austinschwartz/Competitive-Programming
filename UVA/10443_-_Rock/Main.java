import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static char permute(char[][] grid, int i, int j) {
    int r = grid.length;
    int c = grid[0].length;
    char chr = '0';
    if (grid[i][j] == 'S') chr = 'R';
    if (grid[i][j] == 'P') chr = 'S';
    if (grid[i][j] == 'R') chr = 'P';

    // up
    if (i + 1 < r)
      if (grid[i + 1][j] == chr)
        return chr;

    // right
    if (j + 1 < c)
      if (grid[i][j + 1] == chr)
        return chr;

    // down
    if (j - 1 >= 0)
      if (grid[i][j - 1] == chr)
        return chr;

    // left
    if (i - 1 >= 0)
      if (grid[i - 1][j] == chr)
        return chr;

    return grid[i][j];
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      int n = sc.nextInt();
      char[][] gridOne = new char[r][c];
      char[][] gridTwo = new char[r][c];
      for (int j = 0; j < r; j++) {
        char[] line = sc.nextLine().toCharArray();
        for (int k = 0; k < c; k++)
          gridOne[j][k] = line[k];
      }

      for (int j = 0; j < n; j++) {

        for (int k = 0; k < r; k++)
          for (int l = 0; l < c; l++)
            gridTwo[k][l] = gridOne[k][l];

        for (int k = 0; k < r; k++)
          for (int l = 0; l < c; l++ )
            gridOne[k][l] = permute(gridTwo, k, l);

      }

      for (int j = 0; j < r; j++)
        for (int k = 0; k < c; k++)
          System.out.print(gridOne[j][k]);

        System.out.println();

      if (i < t - 1)
        System.out.println();
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
