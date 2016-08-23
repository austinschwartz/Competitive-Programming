import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
      
    List<Long> nums = new ArrayList<Long>();
    while (sc.hasNext())
      nums.add(sc.nextLong());

    int n = nums.size();
    long[] dp = new long[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; i++)
      for (int j = 0; j < i; j++)
        if (nums.get(i) > nums.get(j) && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;

    long max = 0;
    for (int i = 0; i < n; i++)
      max = Math.max(max, dp[i]);

    out.println(max);
    out.println("-");
    print(dp, nums, n - 1, max, out);

    out.close();
  }

  public static void print(long[] dp, List<Long> nums, int i, long max, PrintWriter out) {
    if (max <= 0)
      return;
    if (dp[i] == max) {
      print(dp, nums, i - 1, max - 1, out);
      out.println(nums.get(i));
    } else {
      print(dp, nums, i - 1, max, out);
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
