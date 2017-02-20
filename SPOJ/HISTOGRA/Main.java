import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] hist;
  public static int f(int[] hist, int n) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int min = hist[i];
      for (int j = i; j < n; j++) {
        min = Math.min(min, hist[j]);  
        int rect = (j - i + 1) * min;
        max = Math.max(rect, max);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        break;
      hist = new int[n];
      for (int i = 0; i < n; i++) {
        hist[i] = sc.nextInt();
      }
      out.println(f(hist, n));
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
