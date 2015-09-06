import java.util.*;
import java.io.*;

class Main {
  public static boolean isBipartite(int[][] edges, int n, int source) {
    int[] colors = new int[n];
    for (int i = 0; i < n; i++) {
      colors[i] = -1;
    }
    colors[source] = 1;

    Queue<Integer> queue = new ArrayDeque<Integer>();
    queue.add(source);
    while (!queue.isEmpty()) {
      int u = queue.remove();
      for (int v = 0; v < n; v++) {
        if (edges[u][v] == 1 && colors[v] == -1) {
          colors[v] = (colors[u] == 1 ? 0 : 1);
          queue.add(v);
        } else if (edges[u][v] == 1 && colors[v] == colors[u]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0)
        break;
      int l = Integer.parseInt(br.readLine());
      int[] nodes = new int[n];
      int[][] edges = new int[n][n];
      /*      
      for (int x = 0; x < n; x++) {
        edges[x][x] = 1;
      }
      */
      int source = -1;
      for (int i = 0; i < l; i++) {
        String[] arr = br.readLine().split(" ");
        int n1 = Integer.parseInt(arr[0]);
        int n2 = Integer.parseInt(arr[1]);
        if (source == -1)
          source = n1;
        edges[n1][n2] = 1;
        edges[n2][n1] = 1;
      }
      /*
      for (int[] str : edges) {
        for (int a : str)
          System.out.print(a + " ");
        System.out.println();
      }
      */
      System.out.println(isBipartite(edges, n, source) ? "BICOLORABLE." : "NOT BICOLORABLE.");
    }
  }
}
