import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static class Pair {
    public int i, x;
    public boolean read;
    public Pair(int i, int x) {
      this.i = i; this.x = x;
      this.read = false;
    }
  }
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int q = sc.nextInt();
    ArrayDeque<Pair>[] apps = (ArrayDeque<Pair>[])new ArrayDeque[n];
    ArrayDeque<Pair> notifications = new ArrayDeque<Pair>();
    int not = 0;
    for (int i = 0; i < q; i++) {
      int typei = sc.nextInt();
      int xi = 0, ti = 0;
      switch (typei) {
        case 1:
          xi = sc.nextInt() - 1;
          not++;
          int i = apps[xi].size();
          apps[xi].addLast(i);
          notifications.addLast(new Pair(i, xi));
          break;
        case 2:
          xi = sc.nextInt() - 1;
          break;
        case 3:
          ti = sc.nextInt();
          break;
      }
      out.println(not);
    }
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
