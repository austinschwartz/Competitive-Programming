import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static ArrayList<Integer>[] adjList;
  public static boolean[] visited;
  public static int totalVisited = 0;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    adjList = new ArrayList[n];
    visited = new boolean[n];
    int m = sc.nextInt();
    if (n != m) {
      out.println("NO");
      out.close();
      return;
    }
    
    for (int i = 0; i < n; i++)
      adjList[i] = new ArrayList<Integer>();
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      adjList[a].add(b);
      adjList[b].add(a);
    }
    visited[0] = true;
    totalVisited = 1;
    dfs(0);
    if (totalVisited < n)
      out.println("NO");
    else
      out.println("FHTAGN!");

    out.close();
  }

  public static void dfs(int v) {
    for (int u : adjList[v]) {
      if (visited[u]) continue;
      visited[u] = true;
      totalVisited += 1;
      dfs(u);
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
