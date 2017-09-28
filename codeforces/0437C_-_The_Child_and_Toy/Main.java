import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n, m;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    m = sc.nextInt();

    int[] weights = new int[n];

    for (int i = 0; i < n; i++)
      weights[i] = sc.nextInt();

    int ret = 0;
    for (int i = 0; i < m; i++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      ret += Math.min(weights[x], weights[y]);
    }

    out.println(ret);
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
