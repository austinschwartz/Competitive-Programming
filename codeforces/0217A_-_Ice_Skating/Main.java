import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int max = 1111;
  public static int n;
  public static int[] x, y;
  public static boolean[] visited;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    x = new int[n];
    y = new int[n];
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      x[i] = a;
      y[i] = b;
    }
    visited = new boolean[n];
    int num = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i])
        continue;
      dfs(i);
      num += 1;
    }
    out.println(num - 1);
    out.close();
  }

  public static void dfs(int v) {
    visited[v] = true;
    for (int i = 0; i < n; i++) {
      if (visited[i]) continue;
      if (x[i] == x[v] || y[i] == y[v]) {
        dfs(i);
      }
    }
  }

  public static boolean oob(int i, int j) {
    if (i < 0 || j < 0 ||
        i >= 1000 || j >= 1000)
      return true;
    return false;
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
