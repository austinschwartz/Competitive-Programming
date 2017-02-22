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
  public static int[][] dp = new int[102][102];
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
    for (int i = 0; i < 102; i++)
      Arrays.fill(dp[i], -1);

    dfs(1, 0);

    out.println(dp[1][q]);
    out.close();
  }

  public static void dfs(int pos, int parent) {
    int[][] dp_v = new int[n + 2][n + 2];
    for (int i = 0; i < n + 2; i++)
      Arrays.fill(dp_v[i], -1);

    dp_v[0][0] = 0;

    int child_num = 1;
    List<Edge> edges = adjList[pos];
    // https://inoi15.discuss.codechef.com/questions/60948/can-anyone-teach-me-dp-on-trees-with-the-help-of-solving-this-question
    for (int i = 0; i < edges.size(); i++) {
      Edge edge = edges.get(i);
      int child = edge.j;
      int weight = edge.x;

      if (child != parent) {
        dfs(child, pos);
        for (int j = 0; j < n; j++) {
          if (dp_v[child_num-1][j] != -1)
            dp_v[child_num][j] = dp_v[child_num-1][j];
          for (int k = 0; k < j; k++) {
            if (dp_v[child_num-1][j-(k+1)] != -1)
              dp_v[child_num][j] = Math.max(
                    dp_v[child_num][j],
                    dp_v[child_num - 1][j- (k + 1)] + weight + dp[child][k]
               );
          }
        }
        child_num++;
      }
    }

    for (int i = 0; i < n; i++) {
      dp[pos][i] = dp_v[child_num - 1][i];
    }

    return;
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
