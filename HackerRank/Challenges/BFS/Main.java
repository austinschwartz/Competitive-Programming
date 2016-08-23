import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      if (i > 0)
        out.println();
      int N = sc.nextInt();
      int M = sc.nextInt();
      ArrayList<Integer>[] edges = (ArrayList<Integer>[])new ArrayList[N];
      for (int j = 0; j < N; j++)
        edges[j] = new ArrayList<Integer>();
      int[] prev = new int[N];
      int[] path = new int[N];
      Arrays.fill(prev, -1);
      Arrays.fill(path, -1);
      for (int j = 0; j < M; j++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        edges[x-1].add(y-1);
        edges[y-1].add(x-1);
      }
      int start = sc.nextInt() - 1;
      Queue<Integer> queue = new LinkedList<Integer>();
      queue.add(start);
      prev[start] = start;
      path[start] = 0;
      while (!queue.isEmpty()) {
        int u = queue.remove();
        
        for (int v : edges[u]) {
          if (prev[v] != -1) continue;
          prev[v] = u;
          path[v] = path[u] + 6;
          queue.add(v);
        }
      }

      for (int j = 0; j < N; j++) {
        if (j == start) continue;
        out.print(path[j]);
        if (j < N - 1)
          out.print(" ");
      }
    }
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

