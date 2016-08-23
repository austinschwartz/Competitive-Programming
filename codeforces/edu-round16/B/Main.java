import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static int nums[], dists[];
  public static Integer indices[];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    
    nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    if (n == 1) {
      System.out.println(nums[0]);
    } else {
      Arrays.sort(nums);
      if (n % 2 == 0) {
        out.println(Math.min(nums[n/2], nums[n/2] - 1));
      } else
        out.println(nums[n/2]);
    }

    out.close();
  }

  public static int euclid(int indx) {
    int dist = 0;
    for (int i = 0; i < n; i++) {
      if (i == indx) continue;
      dist += (Math.abs(nums[i] - nums[indx]));
    }

    return dist;
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
