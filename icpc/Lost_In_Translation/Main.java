import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static List<Edge> edgeList;
  public static class Edge {
    public String a, b;
    public int w, dist_from_e;
    public Edge(String a, String b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }
  } 
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int m = sc.nextInt();
    Map<String, Integer> distFromE = new HashMap<>();
    Map<String, List<String>> edges = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String x = sc.next();
      distFromE.put(x, (int)1e8);
    }
    edgeList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      String[] line = sc.nextLine().split(" ");
      if (!distFromE.containsKey(line[0]))
        distFromE.put(line[0], (int)1e8);
      if (!distFromE.containsKey(line[1]))
        distFromE.put(line[1], (int)1e8);
      edgeList.add(new Edge(line[0], line[1], Integer.parseInt(line[2])));
      List<String> currEdges;
      if (edges.containsKey(line[0]))
        currEdges = edges.get(line[0]);
      else
        currEdges = new ArrayList<String>();
      currEdges.add(line[1]);
      edges.put(line[0], currEdges);


      if (edges.containsKey(line[1]))
        currEdges = edges.get(line[1]);
      else
        currEdges = new ArrayList<String>();
      currEdges.add(line[0]);
      edges.put(line[1], currEdges);
    }
  
    Set<String> visited = new HashSet<>();
    Queue<Thing> queue = new LinkedList<>();
    queue.offer(new Thing("English", 1));
    while (!queue.isEmpty()) {
      Thing curr = queue.poll();
      visited.add(curr.language);
      distFromE.put(curr.language, Math.min(distFromE.get(curr.language), curr.dist));
      for (String neighbor : edges.get(curr.language))  {
        if (!visited.contains(neighbor)) {
          queue.offer(new Thing(neighbor, curr.dist + 1));
        }
      }
    }
    out.close();
  }

  public static class Thing { 
    public String language; public int dist;
    public Thing(String language, int dist) {
      this.language = language; this.dist = dist;
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


class UnionFind {
  private Vector<Integer> p, rank, setSize;
  private int numSets;

  public UnionFind(int N) {
    p = new Vector<Integer>(N);
    rank = new Vector<Integer>(N);
    setSize = new Vector<Integer>(N);
    numSets = N;
    for (int i = 0; i < N; i++) {
      p.add(i);
      rank.add(0);
      setSize.add(1);
    }
  }

  public int findSet(int i) { 
    if (p.get(i) == i) return i;
    else {
      int ret = findSet(p.get(i)); p.set(i, ret);
      return ret; } }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { numSets--; 
    int x = findSet(i), y = findSet(j);
    // rank is used to keep the tree short
    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
    else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
  public int numDisjointSets() { return numSets; }
  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}
