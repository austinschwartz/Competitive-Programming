import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static class Pair {
    public int u, w;
    public Pair(int u, int w) {
      this.u = u;
      this.w = w;
    }
  }
  public static int n, m;
  public static ArrayList<Pair>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int C = sc.nextInt();
    for (int c = 1; c <= C; c++) {
      n = sc.nextInt();
      m = sc.nextInt();
      adjList = (ArrayList<Pair>[])new ArrayList[n];
      for (int i = 0; i < n; i++)
        adjList[i] = new ArrayList<Pair>();
      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        adjList[u].add(new Pair(v, w));
      }

      ArrayList<Integer> dist = new ArrayList<Integer>();
      for (int i = 0; i < n; i++)
        dist.add(INF);

      dist.set(0, 0);

      for (int i = 0; i < n - 1; i++) {
        for (int u = 0; u < n; u++) {
          Iterator it = adjList[u].iterator();
          while (it.hasNext()) {
            Pair p = (Pair)it.next();
            dist.set(p.u, Math.min(dist.get(p.u), dist.get(u) + p.w));
          }
        }
      }
      
      boolean negative_cycle_exists = false;
      for (int u = 0; u < n; u++) {
        Iterator it = adjList[u].iterator();
        while (it.hasNext()) {
          Pair v = (Pair)it.next();
          if (dist.get(v.u) > dist.get(u) + v.w)
            negative_cycle_exists = true;
        }
      }

      if (negative_cycle_exists)
        out.println("possible");
      else
        out.println("not possible");

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
