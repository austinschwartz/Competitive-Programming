import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static ArrayList<int[]>[] adjList;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      adjList = (ArrayList<int[]>[])new ArrayList[n];
      for (int i = 0; i < n; i++)
        adjList[i] = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        int r = sc.nextInt();
        if (r == 0) {
          sc.nextLine();
          continue;
        }
        int[] row = new int[r];
        int[] weights = new int[r];
        for (int j = 0; j < r; j++)
          row[j] = sc.nextInt() - 1;
        for (int j = 0; j < r; j++)
          weights[j] = sc.nextInt();
        for (int j = 0; j < r; j++)
          adjList[row[j]].add(new int[]{i, weights[j]});
      }

      out.println(n + " " + m);
      for (int i = 0; i < n; i++) {
        List<int[]> list = adjList[i];
        out.print(list.size());
        if (list.size() > 0) {
          out.print(" ");
          for (int j = 0; j < list.size(); j++) {
            out.print(list.get(j)[0] + 1);
            if (j < list.size() - 1)
              out.print(" ");
          }
          out.println();
          for (int j = 0; j < list.size(); j++) {
            out.print(list.get(j)[1]);
            if (j < list.size() - 1)
              out.print(" ");
          }
        } else {
          out.println();
        }
        out.println();
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
