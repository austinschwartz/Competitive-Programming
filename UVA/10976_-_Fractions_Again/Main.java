import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int k = sc.nextInt();
      int count = 0;
      StringBuilder sb = new StringBuilder();
      for (int x = 0; x < 99999; x++) {
        try {
          int y = (k * x) / (x - k);
          if (y < 0)
            continue;
          if (y < x)
            continue;
          if (x == 0 && y == 0)
            continue;
          if ((k * x) % (x - k) == 0) {
            sb.append(String.format("1/%d = 1/%d + 1/%d\n", k, y, x)); 
            count++;
          }
        } catch (Exception e) {
          // shit
        }
      }
      System.out.println(count);
      System.out.print(sb.toString());
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
