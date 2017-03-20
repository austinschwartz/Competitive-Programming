import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String a = sc.nextLine();
    String b = sc.nextLine();
    String c = sc.nextLine();
    Map<Character, Integer> am = freq(a);
    Map<Character, Integer> bm = freq(b);
    Map<Character, Integer> cm = freq(c);

    boolean good = check(am, cm) && check(bm, cm);
    for (Map.Entry<Character, Integer> entry : cm.entrySet()) {
      if (entry.getValue() > 0)
        good = false;
    }
    out.println(good ? "YES" : "NO");
    out.close();
  }

  public static boolean check(
      Map<Character, Integer> map, 
      Map<Character, Integer> cmap
    )
  {
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      char ch = entry.getKey();
      int freq = entry.getValue();
      if (cmap.containsKey(ch)) {
        cmap.put(ch, cmap.get(ch) - freq);
        if (cmap.get(ch) < 0) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static Map<Character, Integer> freq(String a) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : a.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);
    return map;
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
