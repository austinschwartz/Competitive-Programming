import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static int[] widths, heights, widthsr, heightsr;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      n = sc.nextInt();
      heights = new int[n];
      heightsr = new int[n];
      widths = new int[n];
      widthsr = new int[n];
      for (int j = 0; j < n; j++) {
        heights[j] = sc.nextInt();
        heightsr[n - j - 1] = heights[j];
      }
      for (int j = 0; j < n; j++) {
        widths[j] = sc.nextInt();
        widthsr[n - j - 1] = widths[j];
      }

      out.println(lis(heights) + " " + lis(heightsr));
      out.println(lis(widths) + " " + lis(widthsr));
      out.println();
    }
    out.close();
  }
  public static int lis(int[] a) {
    int l = 1;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++)
        if (a[i] >= a[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          l = Math.max(l, dp[i]);
        }
    }
    return l;
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
