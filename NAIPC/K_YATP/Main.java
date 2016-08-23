import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] penalties;
  public static int[][] matrix, dist;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    matrix = new int[n][n];
    dist = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], 1 << 25);
      Arrays.fill(matrix[i], -1);
    }

    for (int i = 0; i < n; i++) 
      dist[i][i] = 0;

    penalties = new int[n];
    for (int i = 0; i < n; i++)
      penalties[i] = sc.nextInt();

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int w = sc.nextInt();
      matrix[a-1][b-1] = w;
      matrix[b-1][a-1] = w;
      dist[a-1][b-1] = w;
      dist[b-1][a-1] = w;
    }

    // penalty endpoint matrix
    int[][] p = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        p[i][j] = penalties[i] * penalties[j];
  
    int[] d = new int[n];
    for (int i = 0; i < n; i++)
      d[i] = penalties[i] * penalties[i];

    //out.println(Arrays.toString(d));

    /*
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j == i) continue;
        d[i] = Math.min(d[i], p[i][j] + dist[i][j]);
      }
    }
    */

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] > (dist[i][k] + dist[k][j])) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
          d[i] = Math.min(dist[i][j] + p[i][j], d[i]);
        }
      }
    }

    //out.println(Arrays.toString(d));

    int min_cost_sum = 0;
    for (int i = 0; i < n; i++)
      min_cost_sum += d[i];   

    out.println(min_cost_sum);

    
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
