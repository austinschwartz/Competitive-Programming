import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = -1;
    while ((n = sc.nextInt()) != 0) {
      int[] nums = new int[n];
      for (int i = 0; i < n; i++)
        nums[i] = sc.nextInt();
      Arrays.sort(nums);

      int x = f(nums, n);

      if (x < 0 || x >= n)
        out.println("no solution");
      else
        out.println(nums[x]);
    }
    out.close();
  }

  public static int f(int[] nums, int n) {
    for (int d = n - 1; d >= 0; d--) {
      for (int c = 0; c < n; c++) {
        if (c == d)
          continue;

        for (int a = 0 ; a < n - 1; a++) {
          if (a == c || a == d || c == d)
            continue;
          int lookingFor = nums[d] - nums[a] - nums[c];
          int b = Arrays.binarySearch(nums, lookingFor);
          if (b < 0 || b == a || b == c || b == d)
            continue;
          return d;
        }
      }
    }
    return -1;
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
