import java.io.*;
import java.util.*;

public class MainKruskals {
  public static class Edge { 
    public int a, b, weight;
    public Edge(int a, int b, int weight) {
      this.a = a;
      this.b = b;
      this.weight = weight;
    }
  }
  public static int N, W;
  public static int[] parent;
  public static List<Edge> edgeList;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    W = sc.nextInt();
    parent = new int[N];
    edgeList = new ArrayList<Edge>();
    for (int i = 0; i < W; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      int weight = sc.nextInt();
      edgeList.add(new Edge(a, b, weight));
      System.out.println(mstCost());
    }
  }

  public static void makeSet(int v) {
    parent[v] = v; 
  }

  public static int findSet(int v) {
    return parent[v] = (parent[v] == v ? v : findSet(parent[v]));
  }

  public static void union(int p, int q) {
    p = findSet(p);
    q = findSet(q);
    parent[p] = q;
  }

  public static int mstCost() {
    Collections.sort(edgeList, new Comparator<Edge>() {
      @Override
      public int compare(Edge a, Edge b) {
        return Integer.compare(a.weight, b.weight);
      }
    });

    for (int i = 0; i < N; i++)
      makeSet(i);

    int cost = 0;
    Set<Integer> nodesCovered = new HashSet<>();
    for (Edge e : edgeList) {
      if (findSet(e.a) != findSet(e.b)) {
        union(e.a, e.b);
        cost += e.weight;
        nodesCovered.add(e.a);
        nodesCovered.add(e.b);
      }
    }

    return nodesCovered.size() == N ? cost : -1;
  }
}
