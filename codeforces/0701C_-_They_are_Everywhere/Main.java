import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    String line = sc.nextLine();
    char[] chars = line.toCharArray();
    int[] len = new int[n];
    Arrays.fill(len, (int)(1e8));
    Map<Character, Integer> lastIndex = new HashMap<>();
    for (int i = 0; i < n; i++)
      lastIndex.put(chars[i], -1);
    int ret = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      lastIndex.put(chars[i], i);
      int mi = Integer.MAX_VALUE;
      int ma = Integer.MIN_VALUE;
      int count = 0;
      for (char c : lastIndex.keySet()) {
        if (lastIndex.get(c) == -1)
          break;
        mi = Math.min(mi, lastIndex.get(c));
        ma = Math.max(ma, lastIndex.get(c));
        count += 1;
      }
      if (count == lastIndex.keySet().size()) {
        ret = Math.min(ret, ma - mi + 1);
      }
    }
    out.println(ret);
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
