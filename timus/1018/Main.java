import java.io.*;
import java.util.*;

public class Main {
  public static class Edge {
    public int j, x;
    public Edge(int j, int x) {
      this.j = j;
      this.x = x;
    }
  }
  public static PrintWriter out;
  public static ArrayList<Edge>[] adjList;
  public static int n, q;
  public static int ma = 6;
  public static int[][] dp = new int[ma][ma];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    adjList = (ArrayList<Edge>[])new ArrayList[n + 1];

    for (int i = 0; i < n + 1; i++)
      adjList[i] = new ArrayList<Edge>();

    q = sc.nextInt();
    for (int l = 0; l < n - 1; l++) {
      int i = sc.nextInt();
      int j = sc.nextInt();
      int x = sc.nextInt();
      adjList[i].add(new Edge(j, x));
      adjList[j].add(new Edge(i, x));
    }
    for (int i = 0; i < ma; i++)
      Arrays.fill(dp[i], -1);

    out.println(dfs(1, q));

    out.close();
  }

  public static int dfs(int i, int q) {
    if (i >= ma || i < 0 || q >= ma || q < 0) return Integer.MIN_VALUE;
    if (dp[i][q] != -1) return dp[i][q];
    if (q == 0) return dp[i][q] = 0;
    
    if (adjList[i].size() == 0) { // Just a leaf node
      return Integer.MIN_VALUE;
    }

    Edge left = adjList[i].get(0);
    int case1 = left.x + dfs(left.j, q - 1);
    if (adjList[i].size() == 1) { // Has just a left/right child
      return dp[i][q] = case1;
    }

    Edge right = adjList[i].get(1);
    int case2 = right.x + dfs(right.j, q - 1);
    // If we've gotten here, we have both children nodes, so we can check all 3 cases
    int case3 = Math.max( 
       left.x + dfs(left.j, q - 2),
       right.x + dfs(right.j, q - 2));

    return dp[i][q] = Math.max(case1, Math.max(case2, case3));

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
