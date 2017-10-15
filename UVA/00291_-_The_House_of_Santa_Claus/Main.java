import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[][] m = new int[][]{
    {0, 0, 0, 0, 0, 0},
    {0, 0, 1, 1, 0, 1},
    {0, 1, 0, 1, 0, 1},
    {0, 1, 1, 0, 1, 1},
    {0, 0, 0, 1, 0, 1},
    {0, 1, 1, 1, 1, 0}
  };
  public static int[] ans;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    ans = new int[11];
    dfs(1, 1);    
    out.close();
  }

  public static void dfs(int u, int cnt) {
    ans[cnt] = u;
    if (cnt == 9) {
      for (int i = 1; i <= 9; i++)
        out.print(ans[i]);
      out.println();
    } else {
      for (int v = 1; v <= 5; v++) {
        if (m[u][v] == 1) {
          m[u][v] = 0;
          m[v][u] = 0;
          dfs(v, cnt + 1);
          m[u][v] = 1;
          m[v][u] = 1;
        }
      }
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
