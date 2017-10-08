import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int MAX = 1000001;
      ArrayList<Integer>[] adjList = (ArrayList<Integer>[])new ArrayList[MAX];
      for (int i = 0; i < MAX; i++)
        adjList[i] = new ArrayList<Integer>();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
        adjList[a[i]].add(i + 1);
      }
      for (int i = 0; i < m; i++) {
        int k = sc.nextInt();
        int v = sc.nextInt();
        ArrayList<Integer> x = adjList[v];
        if (k > x.size())
          out.println("0");
        else
          out.println(x.get(k - 1));
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
