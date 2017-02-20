import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long[] BITree;

  public static void updateBIT(int i, long x) {
    while (i < BITree.length) {
      BITree[i] += x;
      i += (i & (-i));
    }
  }

  public static long sum(int i) {
    long sum = 0;
    while (i > 0) {
      sum += BITree[i];
      i -= (i & (-i));
    }
    return sum;
  }

  public static long rangeSum(int i, int j) {
    return sum(j) - sum(i - 1);
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();
    BITree = new long[N + 2];
    for (int i = 1; i <= N; i++) {
      updateBIT(i, sc.nextInt());
    }

    int Q = sc.nextInt();
    for (int q = 0; q < Q; q++) {
      char c = sc.nextChar();
      int  i = sc.nextInt();
      long j = sc.nextLong();
      if (c == 'q')
        out.println(rangeSum(i, (int)j));
      if (c == 'u')
        updateBIT(i, j);
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
