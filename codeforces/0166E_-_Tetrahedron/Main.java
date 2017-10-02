import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int MOD = (int)(1e9) + 7;
  public static int MAX = (int)1e8 + 1;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();

    long a = 0;
    long b = 0;
    long c = 0;
    long d = 1;

    for (int i = 0; i < n; i++) {
      long na = (b + c + d) % MOD;
      long nb = (a + c + d) % MOD;
      long nc = (b + a + d) % MOD;
      long nd = (b + c + a) % MOD;
      a = na;
      b = nb;
      c = nc;
      d = nd;
    }
    out.println(d);
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
