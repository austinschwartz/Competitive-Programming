import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static HashMap<String, Integer> map;
  public static HashMap<Integer, String> rev;
  public static ArrayList<String>[] strings;
  public static int global, i;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      i = 0;
      strings = (ArrayList<String>[])new ArrayList[2];
      strings[0] = new ArrayList<String>();
      strings[1] = new ArrayList<String>();
      global = 0;
      map = new HashMap<>();
      rev = new HashMap<>();

      ArrayList<String> s = new ArrayList<>();
      String curr = "-";
      try {
        while (sc.hasNext() && (curr = sc.next()) != null && curr != null && !curr.equals("#"))
        s.add(curr);
      } catch (Exception e) { continue; }

      ArrayList<String> s2 = new ArrayList<>();
      try {
        while (sc.hasNext() && (curr = sc.next()) != null && !curr.equals("#"))
          s2.add(curr);
      } catch (Exception e) { continue; }

      int[] a = convert(s);
      int[] b = convert(s2);
      List<String> ret = lcs(a, a.length, b, b.length);
      for (int k = 0; k < ret.size(); k++) {
        out.print(ret.get(k));
        if (k < ret.size() - 1)
          out.print(" ");
      }
      out.println();
    }
    out.close();
  }

  public static int[] convert(ArrayList<String> strings) {
    int[] ret = new int[strings.size()];
    for (int i = 0; i < strings.size(); i++) {
      String s = strings.get(i);
      if (!map.containsKey(s)) {
        map.put(s, global);
        global += 1;
      }
      ret[i] = map.get(s);
      rev.put(map.get(s), s);
    }
    return ret;
  }

  public static int INF = 0x3f3f3f3f;
  public static List<String> lcs(int[] a, int n, int[] b, int m) {
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= m; j++)
        if (a[i-1] == b[j-1])
          dp[i][j] = dp[i-1][j-1] + 1;
        else
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

    List<String> ret = new ArrayList<String>();

    int i = n;
    int j = m;
    while (i != 0 && j != 0) {
      if (a[i-1] == b[j-1]) {
        ret.add(rev.get(a[i - 1]));
        i -= 1;
        j -= 1;
      } else if (dp[i][j - 1] >= dp[i][j]) {
        j -= 1;
      } else {
        i -= 1;
      }
    }

    Collections.reverse(ret);

    return ret;
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
