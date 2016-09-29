import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int l1, a1, l2, a2;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      l1 = sc.nextInt();
      a1 = sc.nextInt();
      l2 = sc.nextInt();
      a2 = sc.nextInt();
      int lt = sc.nextInt();
      int at = sc.nextInt();
      dp = new Solution[lt + 1][at + 1];

      f(lt, at, 0, 0);
      if (solutions.size() == 1)
        for (Solution sol : solutions)
          out.println(sol.x + " " + sol.y);
      else
        out.println("?");
      solutions.clear();
    }
    out.close();
  }

  public static class Solution {
    public int x, y;
    public Solution(int x, int y) {this.x=x;this.y=y;}

    @Override
    public boolean equals(Object b) {
      Solution bsol = (Solution)b;
      if (this.x == bsol.x && this.y == bsol.y)
        return true;
      return false;
    }

    public int hashCode() {
      return this.x + (this.y << 10);
    }
  }

  public static Set<Solution> solutions = new HashSet<>();
  public static Solution[][] dp;
  public static void f(int lt, int at, int one, int two) {
    if (lt == 0 && at == 0) {
      Solution sol = new Solution(one, two);
      dp[lt][at] = sol;
      solutions.add(sol);
      return;
    }

    if (lt <= 0 || at <= 0)
      return;

    if (lt - l1 >= 0 && at - a1 >= 0)
      f(lt - l1, at - a1, one + 1, two);

    if (lt - l2 >= 0 && at - a2 >= 0)
      f(lt - l2, at - a2, one, two + 1);
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
