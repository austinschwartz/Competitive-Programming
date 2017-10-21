import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      String[] a = sc.nextLine().split(" ");
      String[] b = sc.nextLine().split(" ");
      int m1 = getMonth(a[0]);
      int d1 = Integer.parseInt(a[1].split(",")[0]);
      int y1 = Integer.parseInt(a[2]);
      int m2 = getMonth(b[0]);
      int d2 = Integer.parseInt(b[1].split(",")[0]);
      int y2 = Integer.parseInt(b[2]);
      out.println("Case " + t + ": " + f(m1, d1, y1, m2, d2, y2));
    }
    out.close();
  }

  public static int f(int m1, int d1, int y1, int m2, int d2, int y2) {
    if (m1 > 2) y1 += 1;
    if (m2 < 2 || (m2 == 2 && d2 < 29))
      y2 -= 1;
    int A = ((y2 / 4) - (y1 - 1) / 4);
    int B = ((y2 / 100) - (y1 - 1) / 100);
    int C = ((y2 / 400) - (y1 - 1) / 400);
    return A - B + C;
  }

  public static int getMonth(String s) {
    if (s.equals("January")) return 1;
    if (s.equals("February")) return 2;
    if (s.equals("March")) return 3;
    if (s.equals("April")) return 4;
    if (s.equals("May")) return 5;
    if (s.equals("June")) return 6;
    if (s.equals("July")) return 7;
    if (s.equals("August")) return 8;
    if (s.equals("September")) return 9;
    if (s.equals("October")) return 10;
    if (s.equals("November")) return 11;
    if (s.equals("December")) return 12;
    return -1;
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
