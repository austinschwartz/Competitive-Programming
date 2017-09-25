import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    for (int x = 0; x < t; x++) {
      int n = sc.nextInt();
      Map<Long, Integer> map = new HashMap<>();
      int max = 0;
      int count = 0;
      int ans = 0;
      for (int i = 1; i <= n; i++) {
        long s = sc.nextLong();
        int last_seen = map.getOrDefault(s, -1);
        if (last_seen >= 0) {
          max = Math.max(max, last_seen);
          count = i - max - 1;
        }
        count += 1;
        map.put(s, i);
        ans = Math.max(ans, count);
      }
      System.out.println(ans);
    }
    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
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
