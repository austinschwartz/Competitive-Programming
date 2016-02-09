import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static boolean[][] water;
  public static boolean[][] visited;
  public static int R, C, M, N, even, odd;

  public static boolean reachable(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C || water[r][c])
      return false;
    return true;
  }

  public static void dfs(int a, int b) {
    int count = 0;
    int[][] coords;
    
    if (M == 0)
      coords = new int[][]{ {0, N}, {0, -N}, {N, 0}, {-N, 0} };
    else if (N == 0)
      coords = new int[][]{ {0, M}, {0, -M}, {M, 0}, {-M, 0} };
    else if (M == N)
      coords = new int[][]{ {M, N}, {M, -N}, {-M, N}, {-M, -N} };
    else
      coords = new int[][]{ {M, N}, {M, -N}, {-M, N}, {-M, -N}, 
                            {N, M}, {N, -M}, {-N, M}, {-N, -M} };
    
    for (int[] coord : coords) {
      int c = a + coord[0];
      int d = b + coord[1];
      if (reachable(c, d)) {
        count++;
        if (!visited[c][d]) {
          visited[c][d] = true;
          dfs(c, d);
        }
      }
    }

    if (count % 2 == 0)
      even++;
    else
      odd++;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();

    for (int t = 1; t <= T; t++) {
      R = sc.nextInt();
      C = sc.nextInt();
      water = new boolean[R][C];
      visited = new boolean[R][C];
      visited[0][0] = true;

      M = sc.nextInt();
      N = sc.nextInt();
      int W = sc.nextInt();
      for (int j = 0; j < W; j++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        water[x][y] = true;
      }
      
      even = 0;
      odd = 0;

      dfs(0, 0);

      System.out.printf("Case %d: %d %d\n", t, even, odd);
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
