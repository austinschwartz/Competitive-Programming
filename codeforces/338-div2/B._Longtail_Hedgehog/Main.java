import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static List<Integer>[] adjList;
  public static long[] dp;
  public static int m, n;
  public static int count = 0;

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    m = sc.nextInt();
    dp = new long[n + 1];

    adjList = (ArrayList<Integer>[])new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      adjList[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      adjList[u].add(v);
      adjList[v].add(u);
    }

    for (int i = 1; i <= n; i++) {
      dp[i] = 1;
      for (int j : adjList[i]) {
        if (j < i)
          dp[i] = Math.max(dp[i], dp[j] + 1); 
      }
    }

    long max = -1l;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, dp[i] * (long)adjList[i].size());
    }

    System.out.println(max);
      
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
