import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n, b, p, k, towels, bottles;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    b = sc.nextInt();
    p = sc.nextInt();
    
    bottles = 0;
    towels = n * p;

    int m = n;
    while (m > 1) {
      int k = getK(m);
      int kd = m - k;
      bottles += (k/2) + (k / 2)*b;
      bottles += (kd * b);
      m = k/2;
    }

    out.println(bottles + " " + towels);
    out.close();
  }

  public static int getK(int a) {
    while ((a & (a - 1)) != 0)
      a--;
    return a;
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
