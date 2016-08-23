import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long[][] b;
  public static long[] sums;
  public static BitSet bs;
  public static int n, m, q;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt(); // shelves
    m = sc.nextInt(); // positions
    q = sc.nextInt();
    bs = new BitSet(q + 1);
    b = new long[q + 1][n + 1];
    sums = new long[q + 1];
    b[0][0] = 0L;
    for (int r = 1; r <= q; r++) {
      int op = sc.nextInt();
      if (op == 4) {
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) 
          b[r][j] = b[k][i];
      } else {
        int i = 0, j = 0;
        for (i = 1; i <= n; i++)
          b[r][i] = b[r-1][i];
        switch (op) {
          case 1:
            i = sc.nextInt() - 1;
            j = sc.nextInt() - 1;
            break;
          case 2:
            i = sc.nextInt() - 1;
            j = sc.nextInt() - 1;
            break;
          case 3:
            i = sc.nextInt() - 1;
            break;
        }
      }
      out.println(h(b[r]));
    }
    out.close();
  }

  public static int h(long[][] nums) {
    int ret = 0;
    for (int i = 0; i < n; i++)
    for (int j = 0; j < max; j++)
      ret += h(nums[i][j]);
    return ret;
  }

  public static int h(long n) {
    //int num = 0;
    //while (n != 0) {
      //n = n & (n-1);
      //num++;
    //}
    //return Long.bitCount(n);
     long b = n;
     b = (b & 0x5555555555555555L) + (b >> 1 & 0x5555555555555555L);
     b = (b & 0x3333333333333333L) + (b >> 2 & 0x3333333333333333L);
     b = b + (b >> 4) & 0x0F0F0F0F0F0F0F0FL;
     b = b + (b >> 8);
     b = b + (b >> 16);
     b = b + (b >> 32) & 0x0000007F;

     return (int) b;
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
