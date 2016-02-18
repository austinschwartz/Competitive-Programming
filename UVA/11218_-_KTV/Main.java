import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int maxMask = (1 << 9) - 1;
  public static int n, amt;
  public static int[] masks, costs;
  public static int[][] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    amt = 0;
    int t = 1;
    while (sc.hasNext()) {
      n = sc.nextInt();
      if (n == 0)
        break;
      masks = new int[n];
      costs = new int[n];
      for (int i = 0; i < n; i++) {
        String s = sc.nextLine();
        int mask = toMask(s);
        int cost = Integer.parseInt(s.split(" ")[3]);
        costs[i] = cost;
        masks[i] = mask;
      }
      int o = -1;
      for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++)
          for (int k = j + 1; k < n; k++) {
            int cur = masks[i] | masks[j] | masks[k];
            if (cur == maxMask)
              o = Math.max(o, costs[i] + costs[j] + costs[k]);
          }

      out.printf("Case %d: %d\n", t, o);
      t++;

    }
    out.close();
  }

  public static int toMask(String s) {
    int m = 0;
    int a = s.charAt(0) - '0';
    int b = s.charAt(2) - '0';
    int c = s.charAt(4) - '0';
    m |= (1 << (a - 1));
    m |= (1 << (b - 1));
    m |= (1 << (c - 1));
    return m;
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
