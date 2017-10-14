import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String[] line = sc.nextLine().split(" ");
      BigInteger a = new BigInteger(line[0]);
      BigInteger b = new BigInteger(line[2]);
      out.println(frac(a, b));
    }
    out.close();
  }

  public static BigInteger gcd(BigInteger a, BigInteger b) {
    if (b.equals(BigInteger.valueOf(0)))
        return a;
    if (a.compareTo(b) >= 0 && b.compareTo(BigInteger.valueOf(0)) > 0)
      return gcd(b, a.mod(b));
    return gcd(b, a);
  }   

  public static String frac(BigInteger a, BigInteger b) {
    BigInteger g = gcd(a, b);
    return a.divide(g) + " / " + b.divide(g);
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
