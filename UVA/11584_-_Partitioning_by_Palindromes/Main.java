import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    while ((t--) > 0) {
      char[] s = sc.nextLine().toCharArray();
      int n = s.length;
      if (isPalindrome(s, 0, n - 1)) {
        out.println(1);
        continue;
      }

      int[] dp = new int[n + 1];
      Arrays.fill(dp, 0x3f3f3f3f);
      dp[0] = 0;
      dp[1] = 1;

      for (int i = 1; i < n; i++) {
        for (int j = 0; j <= i; j++) {
          if (isPalindrome(s, j, i))
            dp[i+1] = Math.min(dp[i+1], dp[j] + 1);
        }
      }

      out.println(dp[n]);
    }
    out.close();
  }

  public static boolean isPalindrome(char[] s, int i, int j) {
    while (i <= j) {
      if (s[i] != s[j])
        return false;
      i += 1;
      j -= 1;
    }
    return true;
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
