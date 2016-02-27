import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N;
  public static int[][] dist, next;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = 1;
    while (true) {
      N = sc.nextInt();
      if (N == 0)
        break;
      dist = new int[N][N];
      next = new int[N][N];
      for (int i = 0; i < N; i++) {
        Arrays.fill(dist[i], (int)1e8);
        Arrays.fill(next[i], -1);
      }

      for (int i = 0; i < N; i++) {
        int m = sc.nextInt();
        for (int j = 0; j < m; j++) {
          int v = sc.nextInt();
          int w = sc.nextInt();
          dist[i][v-1] = w;
          next[i][v-1] = v-1;
        }
      }
      int s = sc.nextInt();
      int d = sc.nextInt();
      
      for (int k = 0; k < N; k++)
        for (int i = 0; i < N; i++)
          for (int j = 0; j < N; j++)
            if (dist[i][j] > dist[i][k] + dist[k][j]) {
              dist[i][j] = dist[i][k] + dist[k][j];
              next[i][j] = next[i][k];
            }

      String path = path(s-1, d-1);
      out.printf("Case %d: Path = %s; %d second delay\n", t++, path, dist[s-1][d-1]);
      
    }
    out.close();
  }

  public static String path(int u, int v) {
    if (next[u][v] == -1)
      return "";

    StringBuilder sb = new StringBuilder();
    sb.append((u + 1));
    while (u != v) {
      u = next[u][v];
      sb.append(" " + (u + 1));
    }
    return sb.toString();
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
