import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int[] baseNums = new int[n + 1];
    for (int i = 0; i < n; i++)
      baseNums[i] = sc.nextInt();

    while (true) {
      String line = sc.nextLine();
      if (line == null || line.equals(""))
        break;
      String[] ok = line.split(" ");
      
      int[] nums = new int[n + 1];
      nums[n] = baseNums[0];
      for (int i = 1; i < n; i++)
        nums[Integer.parseInt(ok[i-1])] = baseNums[i];


      int[] dp = new int[n + 1];
      Arrays.fill(dp, 0);

      int largest = 0;
      for (int i = 1; i <= n; i++) {
        int max = 0;
        for (int j = i - 1; j >= 0; j--) {
          if (nums[i] > nums[j])
            if (dp[j] > max)
              max = dp[j];
        }
        dp[i] = max + 1;
        largest = Math.max(max, largest);
      }
      out.println(largest + 1);
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
