import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    while (n-- > 0) {
      char[] str = sc.nextLine().toCharArray();
      Map<Character, Integer> map = new HashMap<>();
      map.put('M', 0);
      map.put('A', 0);
      map.put('R', 0);
      map.put('G', 0);
      map.put('I', 0);
      map.put('T', 0);
      for (char c : str)
        map.put(c, map.getOrDefault(c, 0) + 1);
      int ret = Integer.MAX_VALUE;
      ret = Math.min(ret, map.get('M'));
      ret = Math.min(ret, map.get('A') / 3);
      ret = Math.min(ret, map.get('R') / 2);
      ret = Math.min(ret, map.get('G'));
      ret = Math.min(ret, map.get('I'));
      ret = Math.min(ret, map.get('T'));
      out.println(ret);

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
