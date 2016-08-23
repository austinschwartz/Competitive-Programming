import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int t, K, N, R;
  public static ArrayList<Integer>[] adj;
  public static int[][] length;
  public static int[][] tolls;
  public static int[][][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int K = sc.nextInt(); // max coins he can spend
      int N = sc.nextInt(); // # of cities

      length = new int[N][N];
      tolls = new int[N][N];
      adj = (ArrayList<Integer>[])new ArrayList[N];
      for (int j = 0; j < N; j++)
        adj[j] = new ArrayList<Integer>();
      dp = new int[N][N][K];
      for (int j = 0; j < N; j++)
        for (int k = 0; k < N; k++)
          Arrays.fill(dp[j][k], -1);

      int R = sc.nextInt(); // # of roads
      for (int j = 0; j < R; j++) {
        int S = sc.nextInt() - 1; // source city
        int D = sc.nextInt() - 1; // dest city
        int L = sc.nextInt(); // road length
        int T = sc.nextInt(); // toll
        length[S][D] = L;
        tolls[S][D]  = T;
        adj[S].add(D);
      }
      out.println(toll(0, N - 1, K));
    }
    out.close();
  }

  public static int toll(int u, int v, int c) {
    if (c > K) return Integer.MIN_VALUE;
    if (dp[u][v][c] != -1)
      return dp[u][v][c];

    int ret = Integer.MAX_VALUE;
    for (int node : adj[u]) {
      if (node == v) continue;
      ret = Math.min(
    }

    return dp[u][v][c] = ret;
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
