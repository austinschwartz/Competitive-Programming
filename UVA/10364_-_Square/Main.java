import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, M, sum, maxMask;
  public static int[] S;
  public static Boolean[] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      M = sc.nextInt();
      maxMask = (1 << M) - 1;
      S  = new int[M];
      dp = new Boolean[M];
      Arrays.fill(dp, null);

      sum = 0;
      for (int j = 0; j < M; j++) {
        S[j] = sc.nextInt();
        sum += S[j];
      }

      int v = sum / 4;

      if ((v * 4) != sum || !f(0, v))
        out.println("no");
      else
        out.println("yes");

    }
    out.close();
  }

  public static boolean f(int mask, int v) {
    if (mask == maxMask)
      return true;
    if (dp[mask] != null)
      return dp[mask];

    boolean res = false;
    for (int i = 0; i < M; i++) {
      if (mask & (1 << i) > 0)
        continue;
      for (int j = i + 1; j < M; j++) {
        if (mask & (1 << j) > 0)
          continue;
        if (f(mask | (1 << j) | (1 << i), ))

      }
    }
    
    
    return dp[mask] = res;
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
