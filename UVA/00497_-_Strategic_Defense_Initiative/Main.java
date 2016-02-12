import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static List<Long> list;
  public static long[] dp;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    long n = sc.nextLong();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      list = new ArrayList<Long>();
      String line;
      while ((line = sc.nextLine()) != null && !line.equals(""))
        list.add(Long.valueOf(line.trim()));
      lisList = new LinkedList<Long>();
      print(list.size() - 1, lis());
      out.printf("Max hits: %d\n", lisList.size());
      for (long x : lisList)
        out.println(x);
      if (i < n - 1)
        out.println();
    }
    out.close();
  }

  public static long lis() {
    int n = list.size();
    dp = new long[n];
    Arrays.fill(dp, 1);
    long max = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i) > list.get(j) && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;
        max = Math.max(max, dp[i]);
      }
    }
    return max;
  }
  public static LinkedList<Long> lisList;
  public static void print(int i, long max) {
    if (max <= 0 || i < 0)
      return;
    if (dp[i] == max) {
      print(i - 1, max - 1);
      lisList.add(list.get(i));
    } else {
      print(i - 1, max);
    }
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
