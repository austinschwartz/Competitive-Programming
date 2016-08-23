import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int M, C;
  public static ArrayList<Integer>[] garments;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    dp = new int[201][5000];
    for (int i = 0; i < 201; i++)
      Arrays.fill(dp[i], -1);
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      M = sc.nextInt();
      C = sc.nextInt();
      garments = (ArrayList[])new ArrayList[C];
      for (int j = 0; j < C; j++) {
        int K = sc.nextInt();
        garments[j] = new ArrayList<Integer>();
        for (int k = 0; k < K; k++) {
          garments[j].add(sc.nextInt());
        }
      }
      int res = wedding(M, 0);
      if (res == 0)
        out.println("no solution");
      else
        out.println(res);
    }
    out.close();
  }

  public static int wedding(int m, int g) {
    if (m < 0)
      return Integer.MIN_VALUE;
    if (g == C)
      return M - m;
    if (dp[m][g] != -1)
      return dp[m][g];

    int K = garments[g].size();

    int answer = 0;
    for (int i = 0; i < K; i++) {
      answer = Math.max(answer, wedding(m - garments[g].get(i), g + 1));
    }
    return dp[m][g] = answer;
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
