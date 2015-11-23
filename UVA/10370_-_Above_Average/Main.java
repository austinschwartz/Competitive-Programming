import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static double avg(int[] G, int N) {
    int total = 0;
    float Nf = N;
    for (int num : G)
      total += num;
    return total / Nf;
  }
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int C = sc.nextInt();
    for (int i = 0; i < C; i++) {
      int N = sc.nextInt();
      int[] G = new int[N];
      for (int j = 0; j < N; j++) {
        G[j] = sc.nextInt();
      }
      double avg = avg(G, N);
      int count = 0;
      for (int j = 0; j < N; j++) {
        if (G[j] > avg) {
          count++;
        }
      }
      double aboveAverage = count / (double)N;
      System.out.printf("%.003f%%\n", aboveAverage * 100);
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
