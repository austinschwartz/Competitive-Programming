import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    
    int t = sc.nextInt();
    for (int x = 0; x < t; x++) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[][] dist = new int[N][N];

      for (int i = 0; i < N; i++)
        Arrays.fill(dist[i], 1 << 25);

      for (int j = 0; j < M; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        dist[u][v] = 1;
        dist[v][u] = 1;
      }

      int s = sc.nextInt();
      int d = sc.nextInt();
      int furthest = 0;
      int furthestDist = Integer.MIN_VALUE;
      for (int k = 0; k < N; k++) {
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              if (dist[i][j] > dist[i][k] + dist[k][j])
                dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }

      for (int i = 0; i < N; i++) {
        if (dist[s][i] > furthestDist && dist[s][i] < (1 << 20)) {
          furthest = i;
          furthestDist = dist[s][i];
        }
      }

      System.out.println("Case " + (x + 1) + ": " + (dist[s][furthest] + dist[furthest][d]));
    }

    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
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
