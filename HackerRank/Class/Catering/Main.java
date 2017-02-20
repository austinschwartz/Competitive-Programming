import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N;
  public static int[] profits, P1, P2;
  public static ArrayList<Integer>[] adjList;
  public static boolean[] visited;
  public static boolean[] isleaf;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    N = sc.nextInt();
    profits = new int[N + 1];
    P1 = new int[N + 1];
    P2 = new int[N + 1];
    visited = new boolean[N + 1];
    isleaf = new boolean[N + 1];
    adjList = (ArrayList<Integer>[])new ArrayList[N + 1];
    for (int n = 0; n < N; n++) {
      profits[n + 1] = sc.nextInt();
      adjList[n + 1] = new ArrayList<Integer>();
    }

    for (int n = 0; n < N - 1; n++) {
      int i = sc.nextInt();
      int j = sc.nextInt();
      adjList[i].add(j);
      adjList[j].add(i);
    }

    // Root at first node, find leaves
    int root = 1;
    Arrays.fill(visited, false);
    dfs(root);

    Arrays.fill(visited, false);
    eval(root);
    out.println(Math.max(P1[root], P2[root]));

    out.close();
  }

  public static void eval(int V) {
    visited[V] = true;
    P1[V] = profits[V];
    P2[V] = 0;

    if (isleaf[V]) return;

    for (int adj : adjList[V]) {
      if (!visited[adj]) {
        eval(adj);
        P1[V] += P2[adj];
        P2[V] += Math.max(P1[adj], P2[adj]);
      }
    }
  }

  public static void dfs(int V) {
    if (visited[V]) return;
    visited[V] = true; 
    int neighbors = 0;
    for (int adj : adjList[V]) {
      if (!visited[adj]) {
        neighbors += 1;
        dfs(adj);
      }
    }
    if (neighbors == 0)
      isleaf[V] = true;
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
