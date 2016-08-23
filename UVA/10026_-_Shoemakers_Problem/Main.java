import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static class Thing {
    public Integer index, time, fine;
    public Double d;
    public Thing(int index, int time, int fine) {
      this.index = index;
      this.time = time;
      this.fine = fine;
      d = (double)fine / (double)time;
    }
  }
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      sc.nextLine();
      int N = sc.nextInt();
      Thing[] arr = new Thing[N];
      for (int j = 0; j < N; j++) {
        int time = sc.nextInt();
        int fine = sc.nextInt();
        arr[j] = new Thing(j + 1, time, fine);
      }
      Arrays.sort(arr, new Comparator<Thing>() {
        @Override
        public int compare(Thing a, Thing b) {
          return b.d.compareTo(a.d);
        } 
      });
      for (int m = 0; m < N; m++) {
        System.out.print(arr[m].index);
        if (m < N - 1)
          System.out.print(" ");
      }
      System.out.println();
      if (i < T - 1)
        System.out.println();

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
