import java.io.*;
import java.util.*;

public class Main {
  public static int INF = (int)1e8;
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    ArrayList<int[]>[] adjList;
    for (int l = 1; l <= T; l++) {
      sc.nextLine();
      int n = sc.nextInt();
      int m = sc.nextInt();
      adjList = (ArrayList<int[]>[])new ArrayList[n];
      for (int i = 0; i < n; i++)
        adjList[i] = new ArrayList<int[]>();
      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        adjList[u].add(new int[]{v, w});
        adjList[v].add(new int[]{u, w});
      }

      int t = sc.nextInt();

      int[] dist = new int[n];
      for (int i = 0; i < n; i++)
        dist[i] = INF;
      dist[t] = 0;

      PriorityQueue<int[]> pq = new PriorityQueue<>(1, 
        new Comparator<int[]>() {
          public int compare(int[] i, int[] j) {
            return i[0] - j[0];
          }
        }
      );

      pq.offer(new int[]{0, t});

      while (!pq.isEmpty()) {
        int[] top = pq.poll();
        int d = top[0];
        int u = top[1];
        if (d > dist[u]) continue;
        Iterator it = adjList[u].iterator();
        while (it.hasNext()) {
          int[] p = (int[]) it.next();
          int v = p[0];
          int weight_u_v = Math.max(p[1], d);
          if (weight_u_v < dist[v]) {
            dist[v] =  weight_u_v;
            pq.offer(new int[]{dist[v], v}); 
          }
        } 
      }

      out.println(String.format("Case %d:", l));
      for (int i = 0; i < n; i++)
        out.println(dist[i] == INF ? "Impossible" : dist[i]);
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
