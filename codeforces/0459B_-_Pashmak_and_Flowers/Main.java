import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    long[] nums = new long[n];
    int max_i = 0;
    int min_i = 0;
    long max = Integer.MIN_VALUE;
    long min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextLong();
      if (nums[i] >= max) {
        max = nums[i];
        max_i = i;
      }
      if (nums[i] <= min) {
        min = nums[i];
        min_i = i;
      }
    }

    long maxDiff = max - min;
    long maxCount = 0;
    long minCount = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == max)
        maxCount += 1;
       if (nums[i] == min)
        minCount += 1;
    }

    long nn = n * 1L;
    long count = 0;
    if (max == min)
      count = nn % 2 == 0 ? (nn / 2 * (nn - 1)) : (nn - 1) / 2 * nn;
    else
      count = maxCount * minCount;

    out.println(maxDiff + " " + count);
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
