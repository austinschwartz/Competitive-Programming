import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 1; i <= T; i++) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int t = sc.nextInt();
      int x = f(n, l, r, t);
      out.println(x < 0 ? "uh-oh!" : x);
    }
    out.close();
  }

  public static class Pair {
    public int x, y;
    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public int hashCode() {
      return (x * 0x3f3f3f3f) ^ y;
    }

    @Override
    public boolean equals(Object b) {
      if (b instanceof Pair) {
        return this.y == ((Pair)b).y && 
          this.x == ((Pair)b).x;
      }
      return false;
    }
  }

  public static int f(int n, int l, int r, int t) {
    if (t == 1)
      return 0;
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(0, 0));
    int total = 0;
    Set<Pair> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      Pair cur = queue.poll();
      if (visited.contains(cur))
        continue;
      visited.add(cur);
      int x = cur.x;
      int y = cur.y;
      if (x > 1000 || y > 1000)
        return -1;
      int val = r * x - l * y;
      if (val == t)
        return x + y;
      queue.offer(new Pair(x + 1, y));
      queue.offer(new Pair(x, y + 1));
    }
    return -1;
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
