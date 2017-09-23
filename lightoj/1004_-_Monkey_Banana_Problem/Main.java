import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int[][] matrix = new int[2*N - 1][N];
      int[][] dp = new int[2*N - 1][N];
      for (int i = 0; i < 2 * N - 1; i++)
        Arrays.fill(dp[i], 0);
      for (int i = 1; i <= 2 * N - 1; i++) {
        int x = i > N ? 2 * N - i : i;
        for (int j = 0; j < x; j++) {
          matrix[i - 1][j] = sc.nextInt();
          if (i == 1)
            dp[i - 1][j] = matrix[i-1][j];
          else if (i > N)
            dp[i - 1][j] = matrix[i-1][j] + Math.max(dp[i-2][j], dp[i-2][j+1]);
          else
            if (j == 0)
              dp[i - 1][j] = matrix[i-1][j] + dp[i-2][j];
            else
              dp[i - 1][j] = matrix[i-1][j] + Math.max(dp[i-2][j], dp[i-2][j-1]);
        }
      }
      out.println(String.format("Case %d: %d", (t + 1), dp[2 * N - 2][0]));
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
