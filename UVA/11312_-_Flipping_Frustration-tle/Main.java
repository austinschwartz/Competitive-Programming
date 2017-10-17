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
    public int a, b, c;
    public Pair(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
    @Override
    public int hashCode() {
      return (a * 0x3f3f3f3f) ^ b;
    }

    @Override
    public boolean equals(Object b) {
      if (b instanceof Pair) {
        return this.a == ((Pair)b).a && 
          this.b == ((Pair)b).b;
      }
      return false;
    }
  }

  public static int f(int n, int l, int r, int t) {
    if (n == 1)
      return 0;
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(1, 0, 0));
    int total = 0;
    Set<Pair> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      Pair cur = queue.poll();
      if (visited.contains(cur))
        continue;
      int page = cur.a;
      int prev = cur.b;
      int flips = cur.c;
      out.println(page + " " + prev + " " + flips);
      visited.add(cur);
      if (page == t) {
        return flips;
      }
      if (page + r <= n) {
        int numFlips = Math.abs(t - page) / r; 
        queue.offer(new Pair(page + (numFlips * r), page, flips + numFlips));
        
        //queue.offer(new Pair(page + r, page, flips + 1));
      }
      if (page - l >= 1) {
        int numFlips = Math.abs(page - t) / l; 
        queue.offer(new Pair(page - (numFlips * l), page, flips + numFlips));
        //queue.offer(new Pair(page - l, page, flips + 1));
      }
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
