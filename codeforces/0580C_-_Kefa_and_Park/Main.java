import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static ArrayList<Integer>[] adjList;
  public static int n, m;
  public static boolean[] cats;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    m = sc.nextInt();
    cats = new boolean[n];
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      cats[i] = x == 1 ? true : false;
    }
    adjList = (ArrayList<Integer>[])new ArrayList[n];
    for (int i = 0; i < n; i++)
      adjList[i] = new ArrayList<Integer>();
    for (int i = 0; i < n - 1; i++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      adjList[x].add(y);
      adjList[y].add(x);
    }
    out.println(dfs(-1, 0, cats[0] ? 1 : 0));
    out.close();
  }

  public static long dfs(int par, int i, int c) {
    if (c > m)
      return 0;
    int visited = 0;
    long res = 0;
    for (int j : adjList[i]) {
      if (j == par)
        continue;
      visited += 1;
      if (cats[j])
        res += dfs(i, j, c + 1);
      else
        res += dfs(i, j, 0);
    }

    if (visited == 0)
      res += 1L;
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
