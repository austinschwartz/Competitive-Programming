import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      int t = sc.nextInt();
      String line = sc.next() + " ";
      Pair s = solve(line);
      if (s.b.equals("NO SOLUTION"))
        out.print(t + " NO SOLUTION");
      else
        out.print(t + " " + s.b.length() + (s.b.length() != 0 ? (" " + s.b) : ""));
      out.println(" ");
    }
    out.close();
  }
  public static int[][] s = new int[][]{
      {1, 5},
      {0, 2, 6},
      {1, 3},
      {2, 4},
      {3, 5, 6},
      {4, 0},
      {1, 4}
  };

  public static class Pair {
    public String a;
    public String b;
    public Pair(String a, String b) {
      this.a = a;
      this.b = b;
    }
  }

  public static Pair solve(String st) {
    Queue<Pair> q = new ArrayDeque<Pair>();
    q.offer(new Pair(st, ""));
    Set<String> visited = new HashSet<>();
    while (!q.isEmpty()) {
      Pair p = q.poll();
      String str = p.a;
      visited.add(str);
      if (str.equals("ABCDEF "))
        return p;

      int index = str.indexOf(" ");
      for (int sa : s[index]) {
        char[] a = str.toCharArray();
        char temp = a[sa];
        a[sa] = a[index];
        a[index] = temp;
        String aa = new String(a);
        if (!visited.contains(aa)) {
          q.offer(new Pair(aa, p.b + temp));
        }
        temp = a[index];
        a[index] = a[sa];
        a[sa] = temp;
      }
    }
    return new Pair("", "NO SOLUTION");
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
