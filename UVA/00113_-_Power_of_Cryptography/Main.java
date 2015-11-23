import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
  public static PrintWriter out;
  public static BigInteger calcRoot(BigInteger p, BigInteger n) {
    BigInteger low = BigInteger.ONE;
    BigInteger high = BigInteger.valueOf(1000000000L);
    BigInteger one = BigInteger.ONE;
    while (high.subtract(low).compareTo(one) >= 0) {
      BigInteger mid = low.add(high).divide(BigInteger.valueOf(2));
      int cmp = mid.pow(n.intValue()).compareTo(p);
      if (cmp == 0)
        return mid;
      else if (cmp > 0)
        high = mid.add(one);
      else
        low = mid.subtract(one);
    }
    if (low.pow(n.intValue()).compareTo(p) == 0) {
      return low;
    }
    return high;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      BigInteger n = new BigInteger(sc.next());
      BigInteger p = new BigInteger(sc.next());
      System.out.println(calcRoot(p, n));
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
