import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        break;
      long total = 0;
      TreeMap<Long, Long> map = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        int k = sc.nextInt();
        for (int j = 0; j < k; j++) {
          long x = sc.nextLong();
          if (map.containsKey(x))
            map.put(x, map.get(x) + 1L);
          else
            map.put(x, 1L);
        }
 
        long low = map.firstKey();
        long high = map.lastKey();
        total += (high - low);

        if (map.containsKey(high) && map.get(high) > 1L)
          map.put(high, map.get(high) - 1L);
        else
          map.remove(high);

        if (map.containsKey(low) && map.get(low) > 1L)
          map.put(low, map.get(low) - 1L);
        else
          map.remove(low);
      }
      out.println(total);
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
