import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    long l = sc.nextLong();
    long r = sc.nextLong();
    long k = sc.nextInt();
    long p = k;
    boolean printed = false;
    
    if (l == 1) {
      out.print("1 ");
      printed |= true;
    }
    for (int i = 1; i < 64; ++i) {
      if (k >= l && k <= r) {
        out.print(k + " ");
        printed |= true;
      }
      if (k > r / p)
        break;
      k *= p;
    }
    if (!printed)
      out.print("-1");
    out.println();
    out.close();
  }
  public static double eps = 1e8;


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
