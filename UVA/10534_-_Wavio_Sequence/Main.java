import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++)
        nums[i] = sc.nextInt();

      int[] lis = getLis(nums, n);

      int[] rev = new int[n];
      for (int i = 0; i < n; i++)
        rev[i] = nums[n - i - 1];
      int[] lis2 = getLis(rev, n);

      int ret = 0;
      for (int i = 0; i < n; i++)
        ret = Math.max(ret, 2 * Math.min(lis[i], lis2[n - i - 1]) - 1);
      out.println(ret);
    }
    out.close();
  }

  public static int[] getLis(int[] nums, int n) {
    int[] L = new int[n];
    int[] lis = new int[n];
    int lisCount = 0;
    for (int i = 0; i < n; i++) {
      int pos = Arrays.binarySearch(L, 0, lisCount, nums[i]);
      if (pos < 0)
        pos = -pos - 1;
      L[pos] = nums[i];
      if (pos == lisCount)
        lisCount += 1;
      lis[i] = lisCount;
    }

    return lis;
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
