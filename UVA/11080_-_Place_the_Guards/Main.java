import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int bfs(int[][] matrix, int[] color, int N, int E, int start) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(start);
    int color1 = 0;
    int color2 = 0;
    color[start] = 1;
    color1++;
    while (!queue.isEmpty()) {
      int u = queue.remove();

      for (int v = 0; v < N; v++) {
        if (matrix[u][v] == 1 && color[v] == -1) {
          if (color[u] == 1) {
            color[v] = 0;
            color2++;
          } else if (color[u] == 0) {
            color[v] = 1;
            color1++;
          }
          queue.add(v);
        } else if (matrix[u][v] == 1 && color[v] == color[u]) {
          return -1;
        }
      }
    }
    if (color1 + color2 == 1) return 1;
    else
      return Math.min(color1, color2);
  }

  public static int guards(int[][] matrix, int N, int E) {
    int[] color = new int[N];
    Arrays.fill(color, -1);
    int total = 0;
    for (int i = 0; i < N; i++) {
      if (color[i] == -1) {
        int x = bfs(matrix, color, N, E, i);
        if (x == -1)
          return -1;
        else
          total += x;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int x = 0; x < T; x++) {
      int N = sc.nextInt();
      int E = sc.nextInt();
      int[][] matrix = new int[N][N];
      for (int i = 0; i < E; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        matrix[u][v] = 1;
        matrix[v][u] = 1;
      }
      System.out.println(guards(matrix, N, E));
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
