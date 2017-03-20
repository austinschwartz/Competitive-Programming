import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    int o = 0;
    Arrays.sort(nums);
    for (int a = 0, b = 1, c = 2; c < n; a+=3, b+=3, c+=3) {
      int max = max(
              nums[a],
              nums[b],
              nums[c]
            );
      if ((5 - max) >= k)
        o++;
    }
    out.println(o);
    out.close();
  }

  public static int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
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
