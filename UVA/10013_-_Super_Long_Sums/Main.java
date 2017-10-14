import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      sc.nextLine();
      int M = sc.nextInt();
      int[] sum = new int[M + 1];
      for (int j = 0; j < M; j++) {
        sum[j] = sc.nextInt() + sc.nextInt();
      }
      for (int j = M - 1; j > 0; j--) {
        if (sum[j] > 9) {
          sum[j - 1] += 1;
          sum[j] %= 10;
        }
      }
      for (int j = 0; j < M; j++)
        out.print(sum[j]);
      out.println();
      if (i < N - 1)
        out.println();
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
