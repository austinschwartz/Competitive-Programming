import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int MAX = (int)3e8 + 7;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int l = sc.nextInt();
    int r = sc.nextInt();
    MAX = (r >> 1) + 1;
    BitSet bs = new BitSet(MAX + 1);
    for (int i = 3; i*i <= r; i += 2) {
      if (!bs.get(i >> 1)) {
        for (int j = i * i; j <= r && j > 0; j += (i << 1)) {
          bs.set(j >> 1);
        }
      }
    }
    int ret = 0;
    if (l <= 2 && r >= 2)
      ret ++;
    l = Math.max((int)Math.ceil((l - 1) * 1.0 / 4.0), 1);
    for (int i = (l << 2) + 1; i <= r; i += 4) {
      if (i >= l && !bs.get(i >> 1)) {
        ret += 1;
      }
    }
    out.println(ret);
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
