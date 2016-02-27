import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N;
  public static List<Edge> edgeList1, edgeList2;
  public static class Edge {
    public int u, v, w;
    public Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }

  public static class EdgeComparator implements Comparator<Edge>  {
    @Override
    public int compare(Edge a, Edge b) {
      return new Integer(a.w).compareTo(new Integer(b.w));
    }
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = 1;
    while (sc.hasNext()) {
      if (t++ != 1)
        out.println();
      edgeList1 = new ArrayList<Edge>();
      N = sc.nextInt();
      for (int i = 0; i < N - 1; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int cost = sc.nextInt();
        edgeList1.add(new Edge(u-1, v-1, cost));
      }
      out.println(kruskal(edgeList1));
      
      edgeList2 = new ArrayList<Edge>();
      int K = sc.nextInt();
      for (int i = 0; i < K; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int cost = sc.nextInt();
        edgeList2.add(new Edge(u-1, v-1, cost));
      }

      int M = sc.nextInt();
      for (int i = 0; i < M; i++) {
        int u = sc.nextInt(); 
        int v = sc.nextInt(); 
        int cost = sc.nextInt(); 
        edgeList2.add(new Edge(u-1, v-1, cost));
      }

      out.println(kruskal(edgeList2));
    }

    out.close();
  }

  public static int kruskal(List<Edge> edgeList) {
    Collections.sort(edgeList, new EdgeComparator());
    int mst_cost = 0, not_in_mst_cost = 0;
    int x = 0;
    UnionFind UF = new UnionFind(N);
    for (int i = 0; i < edgeList.size(); i++) {
      Edge front = edgeList.get(i);
      if (!UF.isSameSet(front.u, front.v)) {
        mst_cost += front.w;
        UF.unionSet(front.u, front.v);
        x = front.u;
      }
    }
    return mst_cost;
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


