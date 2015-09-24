import java.util.*;
import java.io.*;

class Main {
  public static int[][] matrix;
  public static Map<String, Integer> drinkMap;
  public static String[] drinkNames;
  public static int[] visited;
  public static List<String> topo;
  public static int V;

  // this doesn't work :(
  public static void dfs(int u) {
    visited[u] = 1;
    for (int i = 0; i < V; i++) {
      if (matrix[u][i] == 1 && visited[i] == 0)
        dfs(i);
    }
    topo.add(drinkNames[u]);
  }

  public static void kahn() {
    int counter = 0;
    topo = new ArrayList<String>();
    PriorityQueue<Integer> noIncoming = new PriorityQueue<Integer>();
    int[] incoming = new int[V];
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (matrix[j][i] == 1)
          incoming[i]++;
      }
      if (incoming[i] == 0)
        noIncoming.offer(i);
    }
    
    while (!noIncoming.isEmpty()) {
      int u = noIncoming.poll();
      topo.add(drinkNames[u]); 
      for (int v = 0; v < V; v++) {
        if (matrix[u][v] == 1) {
          incoming[v] -= 1;
          if (incoming[v] == 0)
            noIncoming.offer(v);
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int index = 1;
    String line;
    while ((line = br.readLine()) != null) {
      while (line != null && line.equals(""))
        line = br.readLine();
      if (line == null)
        return;
      V = Integer.parseInt(line);
      matrix = new int[V][V];
      visited = new int[V];
      drinkMap = new HashMap<String, Integer>();
      drinkNames = new String[V];
      topo = new ArrayList<String>();

      for (int i = 0; i < V; i++) {
        String name = br.readLine();
        drinkMap.put(name, i);
        drinkNames[i] = name;
      }

      int E = Integer.parseInt(br.readLine());
      for (int i = 0; i < E; i++) {
        String[] l = br.readLine().split(" ");
        int u = drinkMap.get(l[0]);
        int v = drinkMap.get(l[1]);
        matrix[u][v] = 1;
      }

      kahn();

      System.out.printf("Case #%d: Dilbert should drink beverages in this order: ", index);
      for (int i = 0; i < topo.size(); i++) {
        System.out.print(topo.get(i));
        if (i < topo.size() - 1)
          System.out.print(" ");
      }
      System.out.println(".\n");
      index++;
    }
  }
}
