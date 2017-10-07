import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      double d = 1.0 * sc.nextInt();
      double v = 1.0 * sc.nextInt();
      double u = 1.0 * sc.nextInt();
      double x = f(d, v, u);
      if (x < 0 || v == 0 || u == 0 || v >= u)
        out.println(String.format("Case %d: %s", i, "can't determine"));
      else
        out.println(String.format("Case %d: %.3f", i, x));
    }
    out.close();
  }

  public static double f(double d, double v, double u) {
    double fastest = d / u;
    double other = d / (double)Math.sqrt((u * u) - (v * v));
    return other - fastest;
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
