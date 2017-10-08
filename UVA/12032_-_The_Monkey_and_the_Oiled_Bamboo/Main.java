import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] r;
  public static int n;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      n = sc.nextInt();
      r = new int[n];
      int min = (int)1e7;
      int max = -1;
      for (int i = 0; i < n; i++) {
        r[i] = sc.nextInt();
        min = Math.min(r[i], min);
        max = Math.max(r[i], max);
      }
      int ans = 0;
      int i = 0, j = 10000007;
      while (i < j) {
        int mid = i + (j - i)/2;
        if (f(j)) {
          j = mid;
        } else {
          i = j;
          j = j + j/2;
        }
      }
      out.println(String.format("Case %d: %d", t, j + 1));
    }
    out.close();
  }

  public static boolean f(int k) {
    int cur = 0, i = 0;
    for (; i < n; i++) {
      int diff = r[i] - cur;
      if (diff > k)
        return false;
      if (diff == k)
        k--;
      cur = r[i];
    }
    return i == n;
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
