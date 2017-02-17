import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void add(int p, int q, int v) {

  }

  public static int sum(int p, int q) {
    return 1;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int C = sc.nextInt();
      for (int c = 0; c < C; c++) {
        int z = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        if (z == 0) {
          int v = sc.nextInt();
          add(p, q, v);
        } else {
          out.println(sum(p, q));
        }
      }
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
