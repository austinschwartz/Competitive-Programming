import java.io.*;
import java.util.*;

public class Main {
  public static class Edge {
    public int v, b;
    public Edge(int v, int b) {
      this.v = v;
      this.b = b;
    }
  }

  private static final int MAX_V = 1000;
  private static int[][] res = new int[MAX_V][];

  private static ArrayList<Integer> p = new ArrayList<Integer>();

  private static void augment(int v, int minEdge) {
    if (v == s) { f = minEdge; return; }
    else if (p.get(v) != -1) { augment(p.get(v), Math.min(minEdge, res[p.get(v)][v]));
                               res[p.get(v)][v] -= f; res[v][p.get(v)] += f; }
  }

  public static PrintWriter out;
  public static int n, s, t, m, f;
  public static ArrayList<Edge>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      if (!sc.hasNext())
        break;

      adjList = new ArrayList[MAX_V];
      for (int i = 0; i < MAX_V; i++)
        adjList[i] = new ArrayList<Edge>();
      n = MAX_V;
      res = new int[MAX_V][MAX_V];
      for (int i = 0; i < MAX_V; i++)
        res[i] = new int[MAX_V];
    
      String[] line = sc.nextLine().split(" ");
      int app   = line[0].charAt(0) - 'A';
      int digit = line[0].charAt(1) - '0';
      char[] runon = line[1].toCharArray();
      
      int mf = 0;
      while (true) {
        f = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> dist = new ArrayList<Integer>();
        dist.addAll(Collections.nCopies(n, INF));
        q.offer(s);
        dist.set(s, 0);
        p.clear();
        p.addAll(Collections.nCopies(n, -1));

        while (!q.isEmpty()) {
          int u = q.poll();
          if (u == t) break; 
          for (Edge vv : adjList[u]) {
            int v = vv.v;
            if (res[u][v] > 0 && dist.get(v) == INF) {
              dist.set(v, dist.get(u) + 1);
              q.offer(v);
              p.set(v, u);
            }
          }
        }

        augment(t, INF);
        if (f == 0) 
          break;
        mf += f;
      }

      out.printf("" + mf);
    }
    out.close();
  }
  public static int INF = (int)1e8;

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
