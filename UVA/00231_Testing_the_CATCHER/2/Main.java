import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static LinkedList<Integer> list;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = 1;
    while (true) {
      list = new LinkedList<Integer>();
      if (!sc.hasNext())
        break;
      while (true) {
        int i = sc.nextInt();
        if (i == -1)
          break;
        list.addFirst(i);
        
      }
      if (list.size() == 0)
        break;
      if (t > 1)
        out.println();
      out.printf("Test #%d:\n  maximum possible interceptions: %d\n", t, lis());
      t++;
    }
    out.close();
  }

  public static int lis() {
    int n = list.size();
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int l = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i) >= list.get(j) && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;
        l = Math.max(dp[i], l);
      }
    }
    return l;
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
