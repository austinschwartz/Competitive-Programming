import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long[][][][][] dp;
  public static String s1, s2;
  public static int len;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    dp = new long[70][2][2][2][2];
    for (int i = 0; i < 70; i++)
      for (int j = 0; j < 2; j++)
        for (int k = 0; k < 2; k++)
          for (int l = 0; l < 2; l++)
            Arrays.fill(dp[i][j][k][l], -1);
    long l = sc.nextLong();
    long r = sc.nextLong();
    s1 = getBin(l);
    s2 = getBin(r);
    if (s1.length() > s2.length()) {
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    while (s1.length() < s2.length())
      s1 = "0" + s1;
    len = s1.length();

    out.println(rec(0, 0, 0, 0, 0));
    out.close();
  }

  public static long rec(int p, int fl1, int fl2, int fr1, int fr2) {
    if (p == len) return 0;
    if (dp[p][fl1][fl2][fr1][fr2] != -1)
      return dp[p][fl1][fl2][fr1][fr2];
    int min1 = 0, max1 = 1;

    if ((fl1 == 0) && (s1.charAt(p) == '1')) min1 = 1;
    if ((fl2 == 0) && (s2.charAt(p) == '0')) max1 = 0;

    int min2 = 0, max2 = 1;
    if ((fr1 == 0) && (s1.charAt(p) == '1')) min2 = 1;
    if ((fr2 == 0) && (s1.charAt(p) == '0')) max2 = 0;

    long res = 0;
    for (int i = min1; i <= max1; i++) {
      for (int j = min2; j <= max2; j++) {
        int v = (i ^ j);
        long toadd = 0;
        if (v == 1) {
          int step = len - p - 1;
          toadd = (1L << step);
        }
        int nfl1 = fl1, nfl2 = fl2, nfr1 = fr1, nfr2 = fr2;
        if (i > s1.charAt(p) - '0') nfl1 = 1;
        if (i < s2.charAt(p) - '0') nfl2 = 1;
        if (j > s1.charAt(p) - '0') nfr1 = 1;
        if (j < s2.charAt(p) - '0') nfr2 = 1;
        long res1 = toadd + rec(p + 1, nfl1, nfl2, nfr1, nfr2);
        res = Math.max(res, res1);
      }
    }
    return dp[p][fl1][fl2][fr1][fr2] = res;

  }

  public static String getBin(long a) {
    StringBuilder sb = new StringBuilder();
    while (a > 0) {
      if ((a & 1) > 0)
        sb.append('1');
      else
        sb.append('0');
      a/=2;
    }
    return sb.reverse().toString();
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
