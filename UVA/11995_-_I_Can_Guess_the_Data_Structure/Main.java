import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      String line = sc.nextLine();
      if (line == null || line.length() == 0)
        break;
      int N = Integer.parseInt(line);
      Stack<Integer> stack = new Stack<Integer>();
      Queue<Integer> queue = new LinkedList<Integer>();
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
      int stackMatches = 0;
      int queueMatches = 0;
      int pqMatches = 0;
      int totalMatches = 0;
      for (int i = 0; i < N; i++) {
        int m = sc.nextInt();
        int x = sc.nextInt();
        if (m == 1) {
          stack.push(x);
          queue.add(x);
          pq.offer(x);
        } else if (m == 2) {
          int st = 0, q = 0, p = 0;
          try {
            st = stack.pop();
            q = queue.remove();
            p = pq.poll();
          } catch (Exception e) { }
          if (st == x) stackMatches++;
          if (q == x) queueMatches++;
          if (p == x) pqMatches++;
          totalMatches++;
        }
      }
      if (totalMatches == pqMatches && 
          totalMatches != stackMatches && 
          totalMatches != queueMatches)
        out.println("priority queue");
      else if (totalMatches != pqMatches && 
                 totalMatches == stackMatches && 
                 totalMatches != queueMatches)
        out.println("stack");
      else if (totalMatches != pqMatches && 
                 totalMatches != stackMatches && 
                 totalMatches == queueMatches)
        out.println("queue");
      else if (totalMatches != pqMatches &&
                totalMatches != stackMatches &&
                totalMatches != queueMatches)
        out.println("impossible");
      else
        out.println("not sure");
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
