import java.io.*;
import java.util.*;

public class Main {
  public static class Pair implements Comparable<Pair>{
    int a, b;
    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
    @Override
    public int compareTo(Pair p) {
      if (p.a == this.a && p.b == this.b)
        return 0;
      else
        return Integer.compare(p.a, this.a);
    }
    public int compare(Pair p1, Pair p2) {
      return p1.compareTo(p2);
    }
    @Override
    public boolean equals(Object a) {
      if (this == a) return true;
      if (a == null) return false;
      if (getClass() != a.getClass())
        return false;
      Pair b = (Pair)a;
      if (this.a != b.a || this.b != b.b)
        return false;
      return true;
    }
    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }
  }
  public static PrintWriter out;
  public static int[] parent;
  public static Map<Integer, Integer> colors[];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int m = sc.nextInt();
    colors = new HashMap[n + 1];
    parent = new int[m + 1];
    for (int i = 0; i <= n; i++) {
      colors[i] = new HashMap<Integer, Integer>();
    }
    for (int i = 1; i <= m; i++)
      parent[i] = i;
    for (int i = 1; i <= m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int prevA = 0;
      int prevB = 0;
      Map<Integer, Integer> aMap = colors[a];
      if (aMap.containsKey(c)) {
        prevA = aMap.get(c);
      }
      Map<Integer, Integer> bMap = colors[b];
      if (bMap.containsKey(c)) {
        prevB = bMap.get(c);
      }
      aMap.put(c, i);
      bMap.put(c, i);
      if (prevA > 0)
        merge(prevA, i);
      if (prevB > 0)
        merge(prevB, i);
    }
    int Q = sc.nextInt();
    Map<Pair, Integer> ans = new HashMap<>();
    for (int i = 0; i < Q; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int ret = 0;
      if (ans.containsKey(new Pair(a, b))) {
        ret = ans.get(new Pair(a, b));
      } else {
        Map<Integer, Integer> aMap = colors[a];
        Map<Integer, Integer> bMap = colors[b];
        if (aMap.size() > bMap.size()) {
          Map<Integer, Integer> cMap = aMap;
          aMap = bMap;
          bMap = cMap;
        }
        for (Map.Entry<Integer, Integer> entry : aMap.entrySet()) {
          int c = entry.getKey();
          int v1 = entry.getValue();
          if (bMap.containsKey(c)) {
            int v2 = bMap.get(c);
            if (find(v1) == find(v2))
              ret += 1;

          }
        }
        ans.put(new Pair(a, b), ret);
      }
      out.println(ret);
    }
    out.close();
  }

  public static int find(int p) {
    return parent[p] = (p == parent[p] ? p : find(parent[p])); 
  }
  public static Random rand = new Random();
  public static void merge(int p, int q) {
    //parent[find(p)] = parent[find(q)];
    p = find(p);
    q = find(q);
    if (rand.nextBoolean())
      parent[p] = q;
    else
      parent[q] = p;
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
