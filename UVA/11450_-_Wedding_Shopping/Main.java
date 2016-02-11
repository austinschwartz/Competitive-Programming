import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, M, C;
  public static ArrayList<Integer>[] garments;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();
    for (int i = 1; i <= N; i++) {
      M = sc.nextInt();
      C = sc.nextInt();
      dp = new int[201][21];
      for (int j = 0; j < 201; j++)
        Arrays.fill(dp[j], -1);
      garments = (ArrayList<Integer>[])new ArrayList[C];
      for (int j = 0; j < C; j++) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        int G = sc.nextInt();
        for (int k = 0; k < G; k++) {
          lst.add(sc.nextInt());
        }
        garments[j] = lst;
      }
      int ret = shop(M, 0);
      if (ret == 0)
        out.println("no solution");
      else
        out.println(ret);
    }
    out.close();
  }

  public static int shop(int m, int g) {
    if (m < 0)
      return Integer.MIN_VALUE;
    if (g == C)
      return M - m;
    if (dp[m][g] == -1) {
      int ans = 0;
      for (int i = 0; i < garments[g].size(); i++) {
        ans = Math.max(ans, shop(m - garments[g].get(i), g + 1));
      }
      dp[m][g] = ans;
    }
    return dp[m][g];
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
