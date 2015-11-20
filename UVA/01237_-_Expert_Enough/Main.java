import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static class Car {
    public int L, H;
    public String M;
    public Car(String M, int L, int H) {
      this.M = M;
      this.L = L;
      this.H = H;
    }
  }
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int D = sc.nextInt();
      Car[] cars = new Car[D];

      for (int j = 0; j < D; j++) {
        String M = sc.next();
        int L = sc.nextInt();
        int H = sc.nextInt();
        cars[j] = new Car(M, L, H);
      }
      int Q = sc.nextInt();
      for (int j = 0; j < Q; j++) {
        int P = sc.nextInt();
        int index = -1;
        for (int k = 0; k < D; k++) {
          if (P >= cars[k].L && P <= cars[k].H) {
            if (index == -1) {
              index = k;
            } else {
              index = -1;
              break;
            }
          }
        }
        if (index != -1) {
          System.out.println(cars[index].M);
        } else {
          System.out.println("UNDETERMINED");
        }
      }
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
