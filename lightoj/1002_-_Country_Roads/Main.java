import java.io.*;
import java.util.*;

public class Main {
  public static int INF = (int)1e8;
  public static PrintWriter out;
  public static class Pair {
    public int u, v;
    public Pair(int u, int v) { this.u = u; this.v = v; }
  }
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    ArrayList<Pair>[] adjList;
    for (int l = 1; l <= T; l++) {
      sc.nextLine();
      int n = sc.nextInt();
      int m = sc.nextInt();
      adjList = (ArrayList<Pair>[])new ArrayList[n];
      for (int i = 0; i < n; i++)
        adjList[i] = new ArrayList<Pair>();
      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        adjList[u].add(new Pair(v, w));
        adjList[v].add(new Pair(u, w));
      }

      int t = sc.nextInt();

      ArrayList<Integer> dist = new ArrayList<>();
      for (int i = 0; i < n; i++)
        dist.add(INF);
      dist.set(t, 0);

      PriorityQueue<Pair> pq = new PriorityQueue<Pair>(1, 
        new Comparator<Pair>() {
          public int compare(Pair i, Pair j) {
            return i.u - j.u;
          }
        }
      );

      pq.offer(new Pair(0, t));

      while (!pq.isEmpty()) {
        Pair top = pq.poll();
        int d = top.u;
        int u = top.v;
        if (d > dist.get(u)) continue;
        Iterator it = adjList[u].iterator();
        while (it.hasNext()) {
          Pair p = (Pair) it.next();
          int v = p.u;
          int weight_u_v = Math.max(p.v, d);
          if (weight_u_v < dist.get(v)) {
            dist.set(v, weight_u_v);
            pq.offer(new Pair(dist.get(v), v)); 
          }
        } 
      }

      out.println(String.format("Case %d:", l));
      for (int i = 0; i < n; i++)
        out.println(dist.get(i) == INF ? "Impossible" : dist.get(i));
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
