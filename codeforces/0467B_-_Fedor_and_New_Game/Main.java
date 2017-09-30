import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] armies = new int[m + 1];
    for (int i = 0; i < m + 1; i++) {
      armies[i] = sc.nextInt();
    }
    int friends = 0;
    for (int i = 0; i < m; i++) {
      if (bitDiffer(armies[m], armies[i]) <= k)
        friends += 1;
    }
    out.println(friends);
    out.close();
  }

  public static int bitDiffer(int a, int b) {
    int count = 0;
    for (int i = 0; i < 20; i++) {
      int x = ((1 << i) & a);
      int y = ((1 << i) & b);
      if (x != y)
        count += 1;
    }
    return count;
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
