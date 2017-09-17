import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      int n = sc.nextInt(); // one-time
      int m = sc.nextInt(); // repeating
      if (n == 0 && m == 0)
        break;
      BitSet b = new BitSet();
      boolean conflict = false;

      for (int i = 0; i < n; i++) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        for (int j = start; j < end; j++) {
          if (b.get(j))
            conflict = true;
          else
            b.set(j);
        }
      }

      for (int i = 0; i < m; i++) {
        int start = sc.nextInt();
        int end   = sc.nextInt();
        int interval = sc.nextInt();
        while (end <= 1000000) {
          for (int j = start; j < end; j++) {
            if (b.get(j))
              conflict = true;
            else
              b.set(j);
          }
          start += interval;
          end += interval;
        }
      }

      if (conflict)
        out.println("CONFLICT");
      else
        out.println("NO CONFLICT");
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
