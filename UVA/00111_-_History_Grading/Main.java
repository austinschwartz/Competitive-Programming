import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = 0;
    int[] orig = new int[0];
    int[] nums = new int[0];
    while (true) {
      String line = sc.nextLine();
      if (line != null && !line.contains(" ")) {
        n = Integer.parseInt(line);
        orig = new int[n];
        String[] ok = sc.nextLine().split(" ");
        for (int i = 0; i < ok.length; i++)
          orig[Integer.parseInt(ok[i]) - 1] = i;
      } else {
        if (line == null || line.equals(""))
          break;
        String[] ok = line.split(" ");
        nums = new int[n];
        for (int i = 0; i < ok.length; i++)
          nums[Integer.parseInt(ok[i]) - 1] = i;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= n; j++) {
            if (nums[i - 1] == orig[j - 1])
              dp[i][j] = dp[i - 1][j - 1] + 1;
            else
              dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
        }
        out.println(dp[n][n]);
      }
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
