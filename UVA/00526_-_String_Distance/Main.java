import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      if (!sc.hasNext()) break;

      char[] a = sc.nextLine().toCharArray();
      char[] b = sc.nextLine().toCharArray();
      
      int len1 = a.length;
      int len2 = b.length;

      int[][] D = new int[len1 + 1][len2 + 1];
      D[0][0] = 0;
      for (int i = 1; i <= len1; ++i)
        D[i][0] = i;
      for (int j = 1; j <= len2; ++j)
        D[0][j] = j;

      for (int i = 1; i <= len1; ++i) {
        for (int j = 1; j <= len2; ++j) {
          D[i][j] = Math.min(
                    Math.min(D[i - 1][j] + 1, 
                             D[i][j - 1] + 1), 
                             D[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 0 : 1));
        }
      }
      StringBuilder sb = new StringBuilder();

      sb.append(D[len1][len2]);
      
      for (int i = 0; i <= len1; i++)
        out.println(Arrays.toString(D[i]));

      out.println(sb.toString());

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
