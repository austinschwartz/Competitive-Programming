import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int timer = 0;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1, 
      new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
          int ret = (a[2] * a[1]) - (b[2] * b[1]);
          if (ret == 0)
            return a[0] - b[0];
          return ret;
        }
    }
  );
    while (true) {
      String instr = sc.nextLine();
      if (instr.equals("#"))
        break;
      String[] sp = instr.split("\\s+");
      int q_num = Integer.parseInt(sp[1]);
      int period = Integer.parseInt(sp[2]);
      pq.offer(new int[]{q_num, period, 1});
    }

    int K = sc.nextInt();
    for (timer = 0; timer < 3000 && K > 0; timer++) {
      int[] x = pq.peek();
      while (timer == (x[2] * x[1]) && pq.size() > 0) {
        pq.poll();
        K--;
        out.println(x[0]);
        pq.offer(new int[]{x[0], x[1], x[2] + 1});
        if (pq.size() > 0)
          x = pq.peek();
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
