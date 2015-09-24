import java.util.*;
import java.io.*;

class Main {
  public static int[][] matrix;
  public static int n;
  public static List<Integer> nodes;
  // VISITED = 1; UNVISITED = 0
  public static int[] dfs_num;

  public static void dfs2(int u) {
    dfs_num[u] = 1;
    for (int i = 0; i < n; i++) {
      int v = matrix[u][i];
      if (v == 1 && dfs_num[i] == 0)
        dfs2(i);
    } 
    nodes.add(u + 1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      nodes = new ArrayList<Integer>();
      String[] line = br.readLine().split(" ");
      n = Integer.parseInt(line[0]); // vertices   
      int m = Integer.parseInt(line[1]); // edges
      if (n == 0 && m == 0)
        return;
      matrix = new int[n][n];
      dfs_num = new int[n];

      for (int l = 0; l < m; l++) {
        line = br.readLine().split(" ");
        int i = Integer.parseInt(line[0]);
        int j = Integer.parseInt(line[1]);
        matrix[i-1][j-1] = 1;
      }

      for (int i = 0; i < n; i++)
        if (dfs_num[i] == 0)
          dfs2(i);
      
      Collections.reverse(nodes);

      for (int i = 0; i < nodes.size(); i++) {
        System.out.print(nodes.get(i));
        if (i != nodes.size() - 1)
          System.out.print(" ");
      }
      System.out.println();
    } 
  }
}
