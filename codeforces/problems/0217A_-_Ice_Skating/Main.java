import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] parent;
  public static int max = 1111;
  public static int n;
  public static int[] x, y;
  public static boolean[] visited;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    parent = new int[n];
    Arrays.fill(parent, -1);
    x = new int[n];
    y = new int[n];
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      parent[i] = i;
      x[i] = a;
      y[i] = b;
    }
    visited = new boolean[n];
    int num = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i])
        continue;
      visited[i] = true;
      for (int j = 0; j < n; j++) {
        if (visited[j]) continue;
        if (find(i) == find(j)) continue;
        if (x[i] == x[j] || y[i] == y[j]) {
          merge(i, j);
          visited[j] = true;
        }
      }
    }
    Arrays.sort(parent);
    for (int i = 1; i < n; i++) {
      if (parent[i] != parent[i-1])
        num++;
    }
    out.println(num);
    out.close();
  }

  public static int find(int x) {
    if (x != parent[x])
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public static Random random = new Random();
  public static void merge(int p, int q) {
    p = find(p);
    q = find(q);
    if (random.nextBoolean()) parent[p] = q;
    else parent[q] = p;
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
