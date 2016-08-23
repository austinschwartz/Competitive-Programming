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
  public static int N, M;
  public static int[][] grid;
  public static ArrayList<Pair>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      N = sc.nextInt();
      M = sc.nextInt();
      grid = new int[N][M];
      adjList = (ArrayList<Pair>[])new ArrayList[N * M];
      for (int j = 0; j < (N * M); j++)
        adjList[j] = new ArrayList<Pair>();
      int pos = 0;
      for (int i = 0; i < N; i++) {
        char[] line = sc.nextLine().toCharArray();
        for (int j = 0; j < M; j++) {
          grid[i][j] = line[2 * j] - '0';
          if (i > 0)
            adjList[pos - M].add(new Pair(pos, grid[i][j]));
          if (j > 0)
            adjList[pos - 1].add(new Pair(pos, grid[i][j]));

          pos++;
        }
      }     

      ArrayList<Integer> dist = new ArrayList<Integer>();

      for (int i = 0; i < (N * M); i++)
        dist.add(INF);

      dist.set(0, 0);

      PriorityQueue<Pair> pq = new PriorityQueue<Pair>(1,
        new Comparator<Pair>() {
          public int compare(Pair i, Pair j) {
            return i.u - j.u;
          }
        }
      );

      pq.offer(new Pair(0, 0));

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

      out.println(grid[0][0] + dist.get((N * M - 1)));

    } 
    out.close();
  }

  public static int INF = (int)1e9;


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
