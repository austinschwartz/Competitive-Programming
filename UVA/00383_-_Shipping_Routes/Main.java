import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static Map<String, Integer> stoi;
  public static Map<Integer, String> itos;
  public static int T, M, N, P;
  public static ArrayList<Integer>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    out.println("SHIPPING ROUTES OUTPUT");
    T = sc.nextInt();
    for (int i = 1; i <= T; i++) {
      stoi = new HashMap<>();
      itos = new HashMap<>();
      N = sc.nextInt(); 
      M = sc.nextInt(); 
      P = sc.nextInt(); 
      adjList = (ArrayList<Integer>[])new ArrayList[N];
      for (int j = 0; j < N; j++)
        adjList[j] = new ArrayList<Integer>();

      for (int j = 0; j < N; j++) {
        String s = sc.next();
        stoi.put(s, j);
        itos.put(j, s);
      }

      for (int j = 0; j < M; j++) {
        String u = sc.next();
        String v = sc.next();
        adjList[stoi.get(u)].add(stoi.get(v));
        adjList[stoi.get(v)].add(stoi.get(u));
      }

      out.printf("\nDATA SET %2d\n\n", i);
      for (int j = 0; j < P; j++) {
        int size = sc.nextInt();
        String s = sc.next();
        String d = sc.next();
        int u = stoi.get(s);
        int v = stoi.get(d);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(u);
        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e8);
        dist[u] = 0;

        while (!queue.isEmpty()) {
          int node = queue.remove();
          for (int adj : adjList[node]) {
            if (dist[adj] == 1e8) {
              dist[adj] = dist[node] + 1;
              queue.add(adj);
            }
          }
        }
        if (dist[v] != (int)1e8)
          out.println("$" + (size * dist[v] * 100)); // size * (path length) * 100
        else
          out.println("NO SHIPMENT POSSIBLE");
      }
    }
    out.println("\nEND OF OUTPUT");
    out.close();
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
