import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] par, ans;
  public static int find(int a) {
    if (a == par[a])
      return a;
    par[a] = find(par[a]);
    return par[a];
  }

  public static void union(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (x == y)
      return;
    int d = Math.max(Math.max(ans[x], ans[y]),
        (int)Math.ceil((float)(ans[x]) / 2.0f) + 
        (int)Math.ceil((float)(ans[y]) / 2.0f) + 1);
    par[x] = par[y];
    ans[par[y]] = d;
  }

  public static int[] dfs(int par, int a, int dist) {
    int[] ret = new int[]{dist, a};
    for (int b : adjList[a]) {
      if (par == b)
        continue;
      int[] cur = dfs(a, b, dist + 1);
      if (cur[0] > ret[0]) {
        ret[0] = cur[0];
        ret[1] = cur[1];
      }
    }
    return ret;
  }

  public static int solve(int a) {
    if (ans[a] != -1)
      return ans[a];
    int[] x = dfs(find(a), find(a), 0);
    ans[a] = dfs(x[1], x[1], 0)[0];
    return ans[a];
  }

  public static ArrayList<Integer>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int m = sc.nextInt();
    int q = sc.nextInt();
    par = new int[n];
    ans = new int[n];
    Arrays.fill(ans, -1);
    adjList = (ArrayList<Integer>[])new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<Integer>();
      par[i] = i;
    }
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      adjList[u].add(v);
      adjList[v].add(u);
      par[find(v)] = find(u);
    }
    for (int i = 0; i < n; i++)
      ans[i] = solve(find(i));
    for (int i = 0; i < q; i++) {
      int a = sc.nextInt();
      int x = sc.nextInt() - 1;
      if (a == 1) {
        out.println(ans[find(x)]);
      } else if (a == 2) {
        int y = sc.nextInt() - 1;
        union(x, y);
      }
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
