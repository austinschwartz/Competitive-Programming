import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static boolean[] visited;
  public static Map<Integer, Integer> map;
  public static ArrayList<Integer>[] adjList;
  public static int[] ans, adj;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      ans = new int[N];
      adj = new int[N];
      Arrays.fill(ans, -1);
      for (int j = 0; j < N; j++) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        adj[u] = v;
      }

      visited = new boolean[N];
      int max = 0;
      int maxIndex = 0;
      for (int j = 0; j < N; j++) {
        if (ans[j] == -1)
          dfs(j);
        if (ans[j] > max) {
          max = ans[j];
          maxIndex = j + 1;
        }
      }

      System.out.println(String.format("Case %d: %d", i + 1, maxIndex));
    }
    out.close();
  }

  public static int dfs(int u) {
    visited[u] = true;

    int v = adj[u];
    int ret = 0;
    if (!visited[v])
      ret += (1 + dfs(v));
    visited[u] = false;

    ans[u] = ret;
    return ret;
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
