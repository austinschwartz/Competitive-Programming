import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int[] nums = new int[n];
    int a = sc.nextInt();
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    if (n <= 1) {
      out.println(0);
    } else {
      Arrays.sort(nums); 
      long min = Long.MAX_VALUE;

      min = Math.min(min, Math.abs(nums[n - 2] - a) + Math.abs(nums[n - 2] - nums[0]));
      min = Math.min(min, Math.abs(nums[n - 1] - a) + Math.abs(nums[n - 1] - nums[1]));
      min = Math.min(min, Math.abs(a - nums[1]) + Math.abs(nums[n - 1] - nums[1]));
      min = Math.min(min, Math.abs(a - nums[0]) + Math.abs(nums[n - 2] - nums[0]));

      out.println(min);
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
