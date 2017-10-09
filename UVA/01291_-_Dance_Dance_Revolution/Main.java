import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int INF = 0x3f3f3f3f;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String line;
    while ((line = sc.nextLine()) != null && !line.equals("0")) {
      String[] sp = line.split(" ");
      int n = sp.length;
      int[] nums = new int[n];
      for (int i = 0; i < n; i++)
        nums[i] = Integer.parseInt(sp[i]);
      int[][][] dp = new int[2][5][5];
      for (int i = 0; i < 2; i++)
        for (int j = 0; j < 5; j++)
          Arrays.fill(dp[i][j], INF);
      dp[0][0][0] = 0;

      int p = 0, q = 1;
      for (int i = 0; i < n - 1; i++) {
        int num = nums[i];
        p = p ^ 1;
        q = q ^ 1;
        for (int j = 0; j < 5; j++)
          Arrays.fill(dp[p][j], INF);
        for (int j = 0; j < 5; j++) {
          for (int k = 0; k < 5; k++) {
            if (j != num)
              dp[p][j][num] = Math.min(dp[p][j][num], dp[q][j][k] + f(k, num));
            if (k != num)
              dp[p][num][k] = Math.min(dp[p][num][k], dp[q][j][k] + f(j, num));
            if (j == num || k == num)
              dp[p][j][k] = Math.min(dp[p][j][k], dp[q][j][k] + 1);
          }
        }
      }

      int ret = 0x3f3f3f3f;
      for (int i = 0; i < 5; i++)
        for (int j = 0; j < 5; j++)
          ret = Math.min(ret, dp[p][i][j]);

      out.println(ret);
    }
    out.close();
  }

  public static int f(int a, int b) {
    if (a == 0 && b == 0) return 0;
    if (a == 0) return 2;
    if (a == b) return 1;
    if (b == 0) return INF;
    if (a == 1 && b == 3) return 4;
    if (a == 2 && b == 4) return 4;
    if (b == 1 && a == 3) return 4;
    if (b == 2 && a == 4) return 4;
    return 3;
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
