import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int b, r, s;
  public static int[] nice;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    b = sc.nextInt();
    for (int i = 1; i <= b; i++) {
      s = sc.nextInt();
      nice = new int[s];
      for (int j = 0; j < s - 1; j++)
        nice[j] = sc.nextInt();

      int best = 0, sum = 0, left = 0, max_sum = 0;
      int saved_left = -1, saved_right = -1;

      for (int j = 0; j < s - 1; j++) {
        sum += nice[j];

        if (sum < 0) {
          sum = 0;
          left = j + 1;
          continue;
        }

        if (sum > max_sum || (sum == max_sum && (j - left) > best)) {
          max_sum = sum;
          saved_left = left;
          saved_right = j;
          best = saved_right - saved_left;
        }
      }
      if (saved_right != -1 && max_sum > 0)
        out.printf("The nicest part of route %d is between stops %d and %d\n", i, saved_left + 1, saved_right + 2);
      else
        out.printf("Route %d has no nice parts\n", i);
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
