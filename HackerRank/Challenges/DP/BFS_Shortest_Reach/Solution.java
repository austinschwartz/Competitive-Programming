import java.util.*;
import java.io.*;

class Solution {
  public static int[][] graph;
  public static int[] visited;
  public static int N;
  public static void bfs(int start) {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(start);
    int prev = -1;
    visited[start - 1] = 0;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      for (int i = 0; i < N; i++) {
        if (graph[node-1][i] == 1 && visited[i] == -1) {
          visited[i] = visited[node-1] + 6;
          queue.add(i + 1);
          prev = node;
        }
      }
    }
    return;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String[] line;
    for (int i = 0; i < T; i++) {
      line = br.readLine().split(" ");
      N = Integer.parseInt(line[0]);
      int M = Integer.parseInt(line[1]);
      graph = new int[N][N];
      visited = new int[N];
      Arrays.fill(visited, -1);
      for (int j = 0; j < N; j++)
        graph[j][j] = 0;
      for (int j = 0; j < M; j++) {
        line = br.readLine().split(" ");
        int l = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        graph[l-1][r-1] = 1;
        graph[r-1][l-1] = 1;
      }
      int S = Integer.parseInt(br.readLine());
      bfs(S);
      List<Integer> lst = new ArrayList<Integer>();
      for (int j = 0; j < N; j++) {
        if (visited[j] != 0)
          lst.add(visited[j]);
      }
      for (int j = 0; j < lst.size(); j++) {
        System.out.print(lst.get(j));
        if (j < lst.size() - 1)
          System.out.print(" ");
        else
          System.out.println();
      }
    }
  }
}
