import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n, b;
  public static int[] B;
  public static int[] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    B = new int[n];
    dp = new int[1 << 12];
    Arrays.fill(dp, -1);
    for (int i = 0; i < n; i++) {
      B[i] = c(sc.nextLine());
      out.println(f(B[i]));
    }
    out.close();
  }

  public static int f(int m) {
    // power of 2
    int ans = numBits(m);
    if (ans == 1)
      return 1;
    if (m != 1 && ((m - 1) & m) == 0)
      return 0;
    if (m == (1 << 12) - 1)
      return 12;
    if (dp[m] != -1)
      return dp[m];

    //find all possible triples, and try to find minimum
    for (int i = 11; i >= 2; i--) {
      boolean A = ((m & (1 << (i    ))) > 0);
      boolean B = ((m & (1 << (i - 1))) > 0);
      boolean C = ((m & (1 << (i - 2))) > 0);

      // can jump C to A
      if (!A && B && C) {
        int x = m;
        x |=  (1 << (i    )); // turn on A
        x &= ~(1 << (i - 1));
        x &= ~(1 << (i - 2));
        ans = Math.min(ans, f(x));
      }

      // can jump A to C
      if (A && B && !C) {
        int x = m;
        x &= ~(1 << (i    )); // turn off A
        x &= ~(1 << (i - 1));
        x |=  (1 << (i - 2)); // turn on c
        ans = Math.min(ans, f(x));
      }
    }
    return dp[m] = ans;
  }

  public static String bits(int m) {
    StringBuilder sb = new StringBuilder();
    for (int i = 11; i >= 0; i--)
      sb.append((m & (1 << i)) > 0 ? "1" : "0");
    return sb.toString();
  }

  public static int numBits(int a) {
    int ret = 0;
    while (a > 0) {
      if ((a & 1) != 0)
        ret++;
      a /= 2;
    }
    return ret;
  }

  public static int c(String s) {
    int mask = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(s.length() - 1 - i) == 'o')
        mask |= (1 << i);
    return mask;
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
