import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int X;
  public static int[][] wsp;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      X = sc.nextInt() / 100;
      wsp = new int[10][X];
      dp  = new int[10][X];
      for (int j = 0; j < 10; j++)
        Arrays.fill(dp[j], -1);

      for (int alt = 9; alt >= 0; alt--)
        for (int dist = 0; dist < X; dist++)
          wsp[alt][dist] = sc.nextInt();

      out.println(fuel(0, 0));
      out.println();
    }

    out.close();
  }

  public static int fuel(int alt, int dist) {
    if (alt == 0 && dist == X)
      return 0;

    if (alt > 9 || alt < 0 || dist > X || dist == X)
      return 1 << 25;

    if (dp[alt][dist] != -1)
      return dp[alt][dist];
    else
      return dp[alt][dist] = 
             Math.min(60 - wsp[alt][dist] + fuel(alt + 1, dist + 1),
             Math.min(30 - wsp[alt][dist] + fuel(alt,     dist + 1),
                      20 - wsp[alt][dist] + fuel(alt - 1, dist + 1)));
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
