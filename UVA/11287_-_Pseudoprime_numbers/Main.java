import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      int p = sc.nextInt();
      int a = sc.nextInt();
      if (p == 0 && a == 0)
        break;
      out.println(isPseudoPrime(p, a) ? "yes" : "no");
    }
    out.close();
  }

  public static boolean isPseudoPrime(int p, int a) {
    BigInteger bp = BigInteger.valueOf(p);
    BigInteger ba = BigInteger.valueOf(a);
    if (bp.isProbablePrime(12))
      return false;
    return ba.modPow(bp, bp).equals(ba);
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
