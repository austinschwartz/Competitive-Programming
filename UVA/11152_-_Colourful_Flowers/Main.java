import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
  public static PrintWriter out;
  static int a, b, c;
  static int p;
  static double s;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      a = sc.nextInt();
      b = sc.nextInt();
      c = sc.nextInt();
      p = a + b + c;
      s = (double)p / 2.0;
      double tri = Math.sqrt(s * (s-(double)a) * (s-(double)b) * (s-(double)c));
      double ir = tri/s;
      double incir = Math.PI * (ir * ir);
      double cr = (a * b * c) / (4 * tri);
      double cicir = Math.PI * (cr * cr);
      out.printf("%.4f ", cicir - tri); // inner circle
      out.printf("%.4f ", tri - incir); // triangle 
      out.printf("%.4f\n", incir);        // outer circle
    }
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
