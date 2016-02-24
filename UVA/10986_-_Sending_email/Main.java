import java.io.*;
import java.util.*;

public class Main {
  public static class Pair {
    public int u, w;
    public Pair(int u, int w) {
      this.u = u;
      this.w = w;
    }
  }
  public static PrintWriter out;
  public static int N;
  public static ArrayList<Pair>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    N = sc.nextInt();
    for (int i = 1; i <= N; i++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int S = sc.nextInt();
      int T = sc.nextInt();
      adjList = (ArrayList<Pair>[])new ArrayList[n];
      for (int j = 0; j < n; j++)
        adjList[j] = new ArrayList<Pair>();
      for (int j = 0; j < m; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        adjList[u].add(new Pair(v, w));
        adjList[v].add(new Pair(u, w));
      }


      ArrayList<Integer> dist = new ArrayList<Integer>();
      for (int j = 0; j < n; j++)
        dist.add(INF);
      dist.set(S, 0);
      PriorityQueue<Pair> pq = new PriorityQueue<Pair>(1, 
        new Comparator<Pair>() {
          public int compare(Pair i, Pair j) {
            return i.u - j.u;
          }
        }
      );

      pq.offer(new Pair(0, S));

      while (!pq.isEmpty()) {
        Pair top = pq.poll();
        int d = top.u;
        int u = top.w;
        if (d > dist.get(u)) continue;
        Iterator it = adjList[u].iterator();
        while (it.hasNext()) {
          Pair p = (Pair) it.next();
          int v = p.u;
          int weight_u_v = p.w;
          if (dist.get(u) + weight_u_v < dist.get(v)) {
            dist.set(v, dist.get(u) + weight_u_v);
            pq.offer(new Pair(dist.get(v), v)); 
          }
        } 
      }
      if (dist.get(T) >= INF || T >= dist.size())
        out.printf("Case #%d: unreachable\n", i);
      else
        out.printf("Case #%d: %d\n", i, dist.get(T));
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
