import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    for (int i = 0; i < n / 2; i++) {
      out.println(f(i, n));
    }
    for (int i = n / 2; i >= 0; i--) {
      out.println(f(i, n));
    }
    out.close();
  }

  public static String f(int i, int n) {
    int ds = (i + 1) * 2 - 1;
    int stars = (n - ds) / 2;
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < stars; j++)
      sb.append("*");
    for (int j = 0; j < ds; j++)
      sb.append("D");
    for (int j = 0; j < stars; j++)
      sb.append("*");
    return sb.toString();
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
