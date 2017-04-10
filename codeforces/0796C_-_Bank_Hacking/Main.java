import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static int[] strength;
  public static ArrayList<Integer>[] adjList;
  public static Set<Integer> leaves = new HashSet<>();
  public static boolean[] marked;
  public static int max;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    adjList = (ArrayList<Integer>[])new ArrayList[n];
    marked = new boolean[n];
    strength = new int[n];
    int m = (int)(-1e9);
    for (int i = 0; i < n; i++) {
      strength[i] = sc.nextInt();
      m = Math.max(m, strength[i] + 2);
      adjList[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < n - 1; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      adjList[u].add(v);
      adjList[v].add(u);
    }

    if (solve(m - 2))
      out.println(m - 2);
    else if (solve(m - 1))
      out.println(m - 1);
    else
      out.println(m);

    out.close();
  }

  public static boolean solve(int ans) {
    int bad = 0;
    for (int i = 0; i < n; i++)
      if (strength[i] + 2 > ans)
        bad += 1;

    for (int v = 0; v < n; v++) {
      int cur = 0;
      if (strength[v] + 2 > ans && strength[v] <= ans)
        cur += 1;

      for (int u : adjList[v])
        if (strength[u] + 2 > ans && strength[u] + 1 <= ans)
          cur += 1;

      if (cur == bad)
        return true;
    }

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
