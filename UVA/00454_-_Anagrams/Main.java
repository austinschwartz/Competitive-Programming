import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    sc.nextLine();
    for (int t = 1; t <= T; t++) {
      if (t != 1)
        out.println();
      String line;
      List<String> list = new ArrayList<String>();
      while ((line = sc.nextLine()) != null && !line.equals("")) {
        list.add(line);
      }
      Collections.sort(list);
      int n = list.size();
      boolean[][] marked = new boolean[n][n];
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (eq(list.get(i), list.get(j)) && !marked[i][j] && !marked[j][i]) {
            out.println(list.get(i) + " = " + list.get(j));
            marked[i][j] = true;
            marked[j][i] = true;
          }
        }
      }
    }
    out.close();
  }

  public static boolean eq(String a, String b) {
    Map<Character, Integer> map1 = m(a);
    Map<Character, Integer> map2 = m(b);
    if (map1.entrySet().size() != map2.entrySet().size())
      return false;
    for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
      if (!map2.containsKey(entry.getKey()))
        return false;
      if (map2.get(entry.getKey()) != entry.getValue())
        return false;
    }
    return true;
  }

  public static Map<Character, Integer> m(String a) {
    Map<Character, Integer> map = new HashMap<>();
    for (String s : a.split(" "))
      for (char c : s.toCharArray())
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
