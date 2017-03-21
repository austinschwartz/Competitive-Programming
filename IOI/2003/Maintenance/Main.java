import java.io.*;
import java.util.*;

public class Main {
  public static class Pair { 
    public int a, pri;
    public Pair(int a, int pri) {
      this.a = a;
      this.pri = pri;
    }
  }
  public static int N, W;
  public static ArrayList<Integer>[] adjList;
  public static int[][] adjMatrix;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    W = sc.nextInt();
    adjMatrix = new int[N][N];
    for (int i = 0; i < N; i++)
      Arrays.fill(adjMatrix[i], (int)(1e8));
    adjList = new ArrayList[N];
    for (int i = 0; i < N; i++)
      adjList[i] = new ArrayList<Integer>();
    for (int i = 0; i < W; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      int x = sc.nextInt();
      adjMatrix[a][b] = Math.min(adjMatrix[a][b], x);
      adjMatrix[b][a] = Math.min(adjMatrix[b][a], x);
      adjList[a].add(b);
      adjList[b].add(a);
      System.out.println(mstCost());
    }
  }

  public static int mstCost() {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
      @Override
      public int compare(Pair a, Pair b) {
        return Integer.compare(a.pri, b.pri);
      }
    });

    boolean[] visited = new boolean[N];
    int[] dist = new int[N];
    pq.offer(new Pair(0, 0));
    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      int w = p.a;
      int pri = p.pri;
      if (!visited[w]) {
        visited[w] = true;
        dist[w] = pri;
        for (int u : adjList[w]) {
          if (!visited[u]) {
            dist[u] = adjMatrix[w][u];
            pq.offer(new Pair(u, dist[u]));
          }
        }
      }
    }

    int cost = -1;
    int count = 0;
    for (boolean v : visited)
      if (v)
        count += 1;

    if (count == N) {
      cost = 0;
      for (int d : dist) {
        cost += d;
      }
    }

    return cost == 0 ? -1 : cost;
  }
}
