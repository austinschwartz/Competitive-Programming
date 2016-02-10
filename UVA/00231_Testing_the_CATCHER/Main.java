import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    LinkedList<Integer> lst = new LinkedList<Integer>();
    int t = 0;
    while (sc.hasNext()) {
      int num = sc.nextInt();
      if (num == -1) {
        if (lst.size() == 0)
          break;
        if (t != 0)
          out.println("");
        t++;
        out.printf("Test #%d:\n", t);
        out.printf("  maximum possible interceptions: %d\n", lis(lst));
        lst = new LinkedList<Integer>();
        continue;
      }
      lst.addFirst(num);
    }
    out.close();
  }

  public static int lis(List<Integer> list) {
    int n = list.size();
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i) >= list.get(j) && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;
      }
    }

    int lis = 1;
    for (int i = 0; i < n; i++)
      lis = Math.max(lis, dp[i]);

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
