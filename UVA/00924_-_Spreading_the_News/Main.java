import java.util.*;
import java.io.*;

class Main {
  public static class Graph {
    public Node[] nodes;
    public int currentSize;
    public int maxSize;
    public Graph(int size) {
      maxSize = size;
      currentSize = 0;
    }
  }

  public static class Node {
    public List<Node> adjacent;
    public String str;
    public int num;
    public int steps;
    public Node prev;
    public Node(String str) {
      this.str = str;
      this.num = Integer.parseInt(str);
      this.steps = 0;
      this.adjacent = new ArrayList<Node>();
    }
  }

  public static void boom(Graph g, int employee) {
    int[] visited = new int[g.maxSize]; // unvisited = 0, visiting = 1, visited = 2

    Queue<Node> queue = new ArrayDeque<Node>();
    Map<String, Integer> map = new TreeMap<String, Integer>();

    Node initial = g.nodes[employee];
    queue.add(initial);
    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      map.put(temp.str, temp.steps);
      if (temp.steps == 0 && temp.adjacent.size() == 0) {
        System.out.println("0");
        return;
      }
      for (Node adj : temp.adjacent) {
        if (visited[adj.num] == 0) {
          adj.steps = temp.steps + 1;
          adj.prev = temp;
          visited[adj.num] = 1;
          queue.add(adj);
        }
      }
      visited[temp.num] = 2;
    }

    int[] counts = new int[g.maxSize];
    for (String key : map.keySet()) {
      counts[map.get(key)]++;
    }

    int max = -1;
    int first = -1;
    for (int o = 0; o < g.maxSize; o++) {
      if (counts[o] > max) {
        first = o;
        max = counts[o];
      }
    }
    System.out.println(max + " " + (first == 0 ? 1 : first));
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int E = Integer.parseInt(br.readLine());

    Graph g = new Graph(E);
    Node[] nodes = new Node[E];
    for (int l = 0; l < E; l++) {
      nodes[l] = new Node(Integer.toString(l));
    }

    for (int i = 0; i < E; i++) {
      String[] temp = br.readLine().split(" ");
      for (int k = 1; k < temp.length; k++) {
        nodes[i].adjacent.add(nodes[Integer.parseInt(temp[k])]); 
      }
    }
    g.currentSize = E;
    g.nodes = nodes;

    int T = Integer.parseInt(br.readLine());
    for (int j = 0; j < T; j++) {
      for (Node m : g.nodes) {
        for (Node n : m.adjacent) {
          n.prev =  null;
          n.steps = 0;
        }
      }
      int employee = Integer.parseInt(br.readLine());
      boom(g, employee);
    }
  }
}
