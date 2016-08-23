import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, Q, D, M;
  public static int[] nums;
  public static int[][][] dp;
  public static List<Integer> res;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    dp = new int[205][15][25];

    out = new PrintWriter(new BufferedOutputStream(System.out));
    int x = 1;
    while ((N = sc.nextInt()) >= 0 && 
           (Q = sc.nextInt()) >= 0 &&
           !(N == 0 && Q == 0)) {
      nums = new int[N];

      for (int i = 0; i < N; i++)
        nums[i] = sc.nextInt();

      out.println("SET " + x + ":");
      for (int q = 0; q < Q; q++) {
        D = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < 205; i++)
          for (int j = 0; j < 15; j++)
            for (int k = 0; k < 25; k++)
              dp[i][j][k] = -1;
        
        out.println("QUERY " + (q + 1) + ": " + query(0, 0, 0));
      }
      x++;
    }
    out.close();
  }

  public static int query(int n, int m, int sum) {
    sum = (sum % D + D) % D;
    if (m == M && sum == 0)
      return 1;
    if (m == M)
      return 0;
    if (n == N)
      return 0;

    if (dp[n][m][sum] == -1)
      dp[n][m][sum] = query(n + 1, m + 1, (sum + nums[n] % D) % D) +
                        query(n + 1, m, sum);

    return dp[n][m][sum];
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
