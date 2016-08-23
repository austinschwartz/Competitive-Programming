import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[][] dp;
  public static int[] weight, favor;
  public static int W, n;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      W = sc.nextInt();
      n = sc.nextInt();
      weight = new int[n];
      favor = new int[n];
      for (int i = 0; i < n; i++) {
        weight[i] = sc.nextInt();
        favor[i]  = sc.nextInt();
      }

      dp = new int[100][15001];
      for (int i = 0; i < dp.length; i++)
        Arrays.fill(dp[i], -1);

      out.println(knapsack(0, 0));
    }
    out.close();  
  }
  
  public static int knapsack(int i, int w) {
    if ((w > W && W < 1800) || (w > W + 200))
      return -9999;
    if (i == n)
      if (w <= 2000 && w > W)
        return -9999;
      else
        return 0;
    
    if (dp[i][w] != -1)
      return dp[i][w];

    int ret = Math.max(knapsack(i+1,w), favor[i] + knapsack(i + 1, w + weight[i]));
    dp[i][w] = ret;
    return ret;

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
