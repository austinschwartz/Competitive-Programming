import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    if (s1.equals(s2) || f(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length()))
      out.println("YES");
    else
      out.println("NO");

    out.close();
  }

  public static boolean f(char[] a, int n, char[] b, int m) {
    if (n != m)
      return false;
    if (n == 1)
      return false;
    boolean aAns = false;
    boolean bAns = false;
    for (int i = 0; i < n; i++) {
      if (a[i] == '1')
        aAns = true;
      if (b[i] == '1')
        bAns = true;
    }
    return aAns && bAns;
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
