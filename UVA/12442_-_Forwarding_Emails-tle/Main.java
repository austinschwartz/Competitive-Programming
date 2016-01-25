import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static boolean[] visited;
  public static Map<Integer, Integer> map;
  public static ArrayList<Integer>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      map = new HashMap<Integer, Integer>();
      adjList = (ArrayList<Integer>[])new ArrayList[N + 1];
      for (int j = 1; j <= N; j++) {
        adjList[j] = new ArrayList<Integer>();
      }

      for (int j = 0; j < N; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        adjList[u].add(v);
      }

      visited = new boolean[N + 1];
      for (int j = 1; j <= N; j++) {
        dfs(j, j, 0);
      }

      int max = Integer.MIN_VALUE;
      for (int key : map.keySet()) {
        int value = map.get(key);
        max = Math.max(value, max);
      }
      int maxKey = Integer.MAX_VALUE;
      for (int key : map.keySet()) {
        if (map.get(key) == max && key < maxKey)
          maxKey = key;
      }
      System.out.println(String.format("Case %d: %d", i + 1, maxKey));
    }
    out.close();
  }

  public static void dfs(int num, int original, int count) {
    if (visited[num]) return;
    visited[num] = true;

    for (int adj : adjList[num]) {
      if (!visited[adj]) {
        dfs(adj, original, count + 1);   
      }
    }
    if (map.containsKey(original)) {
      if (count + 1 > map.get(original)) {
        map.put(original, count + 1);
      }
    } else {
      map.put(original, count + 1);
    }
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
