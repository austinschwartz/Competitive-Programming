import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long r1, r2;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    long g = gcd(a, -c);
    if ((d - b) % g == 0) {
      for (int x = 0; true; x++) {
        int y = (b + (x * a) - d)/c;
        if (b + x*a == d + y*c && y >= 0) {
          out.println(b + x*a);
          break;
        }

      }
    } else {
      out.println("-1");
    }

    out.close();
  }

  public static long gcd(long a, long b) {
    return a % b == 0 ? Math.abs(b) : gcd(b, a % b);
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
