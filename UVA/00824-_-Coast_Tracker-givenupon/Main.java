import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      int x = sc.nextInt();
      if (x == -1) 
        break;
      int y = sc.nextInt();
      int d = sc.nextInt();
      int[][] grid = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
      grid[1][1] = d;
      for (int i = 0; i < 8; i++) {
        int xi = sc.nextInt() - x;
        int yi = sc.nextInt() - y;
        int si = sc.nextInt();
        grid[xi + 1][yi + 1] = si;
      }

      for (int i = 0; i < 3; i++)
        System.out.println(Arrays.toString(grid[i]));

      System.out.println(dfs(grid));
    }
    out.close();
  }

  public int dfs(int[][] grid) {
    int dir = grid[1][1];
    int i = dir;
    for (; i < 8; i++) {
      
    }
    for (; i < dir; i++) {

    }
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
