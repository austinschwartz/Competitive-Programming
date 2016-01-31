import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n, m;
  public static int[] nums;

  public static boolean f(int cap) {
    int tot = 0, cur = 0;
    for (int i = 0; i < n; i++) {
        if(nums[i] > cap)
          return false;
        if(cur + nums[i] > cap)
          cur = 0;
        if(cur == 0)
          tot++;
        cur += nums[i];
        if(tot > m)
          return false;
    }
    return true; 
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      n = sc.nextInt(); // containers
      m = sc.nextInt(); // vessels
      nums = new int[n];

      for (int i = 0; i < n; i++)
        nums[i] = sc.nextInt(); // container capacity

      int low = 0, high = Integer.MAX_VALUE;

      while (high > low) {
        int mid = low + (high - low)/2;
        if (f(high)) {
          high = mid;
        } else {
          low = high;
          high = high + high / 2;
        }
      }
      out.println((high + 1));

      
    }
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
