import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    long a = sc.nextLong();
    long b = sc.nextLong();
    while (!(a == 0 && b == 0)) {
      int carries = 0;
      int carry = 0;
      long al = 0, bl = 0;
      StringBuilder sum = new StringBuilder();
      while (a > 0 || b > 0) {
        if (a > 0) {
          al = a % 10;
          a /= 10;
          carry += al;
        }
        if (b > 0) {
          bl = b % 10;
          b /= 10;
          carry += bl;
        }
        if (carry >= 10)
          carries++;
        long cur = carry % 10;
        sum.append(cur);
        carry /= 10;
      }
      if (carry > 0)
        sum.append(1);
      if (carries == 0)
        System.out.println("No carry operation.");
      if (carries == 1)
        System.out.printf("%d carry operation.\n", carries);
      if (carries > 1)
        System.out.printf("%d carry operations.\n", carries);
      a = sc.nextLong();
      b = sc.nextLong();
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
