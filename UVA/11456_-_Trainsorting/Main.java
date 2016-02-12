import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static int[] dp, nums1, nums2;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      n = sc.nextInt();
      nums1 = new int[n];
      nums2 = new int[n];
      for (int i = n - 1; i >= 0; i--) {
        int x = sc.nextInt();
        nums1[i] = x;
        nums2[i] = -x;
      }

      int[] inc = lis(nums1);
      int[] dec = lis(nums2);

      int ans = 0;

      for (int i = 0; i < n; i++)
        ans = Math.max(ans, inc[i] + dec[i] - 1);

      out.println(an);
      
    }

    out.close();
  }

  public static int[] lis(int[] nums) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int max = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;
      }
    }

    return dp;
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
