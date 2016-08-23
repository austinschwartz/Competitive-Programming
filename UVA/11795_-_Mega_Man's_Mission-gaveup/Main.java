import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, maxState;
  public static int[] grid;
  public static long[] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      N = sc.nextInt();
      grid = new int[N + 1];
      for (int i = 0; i <= N; i++)
        grid[i] = tomask(sc.nextLine());

      maxState = (1 << N) - 1;

      out.printf("Case %d: %d\n", t, ways(megaBuster));
    }
    out.close();
  }

  public static int ways(int m) {
    if (
    return 1;    
  }

  public static int tomask(String s) {
    char[] line = s.toCharArray();
    int bitmask = 0;
    for (int j = N-1; j >= 0; j--)
      bitmask |= ((line[j] == '1' ? 1 : 0) << (N - j  - 1));
    return bitmask;
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
