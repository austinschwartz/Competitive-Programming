import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  //public static HashSet<Integer> globalSet;
  public static short globalSet;
  public static int N;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 1; i <= T; i++) {
      globalSet = 0;
      globalSet |= (1 << 0);
      globalSet |= (1 << 1);
      globalSet |= (1 << 2);
      globalSet |= (1 << 3);
      globalSet |= (1 << 4);
      globalSet |= (1 << 5);
      globalSet |= (1 << 6);
      globalSet |= (1 << 7);
      globalSet |= (1 << 8);
      globalSet |= (1 << 9);
      int n = sc.nextInt();
      if (n == 0)
        out.printf("Case #%d: INSOMNIA\n", i);
      else {
        out.printf("Case #%d: %s\n", i, b(n, 1));
      }
    }
    out.close();
  }

  public static int b(int n, int i) {
    if (globalSet == 0)
      return n * (i - 1);
    int x = n * i;
    while (x > 0) {
      int a = x % 10;
      if (((globalSet >> a) & 1) > 0)
        globalSet &= ~(1 << a);
      x /= 10;
    }
    return b(n, i + 1);
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
