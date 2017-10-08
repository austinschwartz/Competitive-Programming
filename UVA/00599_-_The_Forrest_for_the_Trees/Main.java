import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int vBitset = 0;
      List<char[]> edges = new ArrayList<>();
      while (true) {
        String edge = sc.nextLine();
        if (edge.charAt(0) == '*')
          break;
        edges.add(new char[]{edge.charAt(1), edge.charAt(3)});
      }

      String[] points = sc.nextLine().split(",");
      HashSet<Character> chars = new HashSet<>();
      for (String point : points)
        chars.add(point.charAt(0));

      int E = 0;
      for (char[] edge : edges) {
        char a = edge[0];
        char b = edge[1];
        if (!chars.contains(a)) continue;
        if (!chars.contains(b)) continue;
        E += 1;
        vBitset |= (1 << (a - 'A'));
        vBitset |= (1 << (b - 'A'));
      }

      int V = points.length, acorns = 0;
      for (int i = 0; i < 26; i += 1) {
        if (chars.contains((char)(i + 'A')) && 
            ((1 << i) & vBitset) == 0) {
          acorns += 1;
        }
      }

      int trees = V - E - acorns;
      out.println(String.format("There are %d tree(s) and %d acorn(s).", trees, acorns));
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
