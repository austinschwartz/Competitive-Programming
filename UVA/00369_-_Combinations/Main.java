import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int m, n;
  public static long[][] table = new long[105][105];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    for (int i = 0; i < table.length; i++)
      for (int j = 0; j < table[0].length; j++)
        table[i][j] = 0;

    c(table.length-1, table.length-1);

    while (true) {
      n = sc.nextInt();
      m = sc.nextInt();
      if (n == 0 && m == 0)
        break;

      out.printf("%d things taken %d at a time is %d exactly.\n", n, m, c(n+1, m+1));
    }
    out.close();
  }

  public static long c(int n, int m) {
    if (table[n][m] != 0)
      return table[n][m];

    for (int i = 0; i <= n; i++)
      for (int j = 0; j <= i; j++)
        if (j == 0 || j == 1)
          table[i][j] = 1;
        else
          table[i][j] = table[i-1][j-1] + table[i-1][j];

    return table[n][m];
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
