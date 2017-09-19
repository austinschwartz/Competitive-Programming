import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = 1;
    while (true) {
      int n = sc.nextInt();
      int p = sc.nextInt();
      if (n == 0 && p == 0)
        break;
      String best = "";
      for (int i = 0; i < n; i++) {
        String req = sc.nextLine();
      }
      double best_compliance = -1.0;
      double best_compliance_price = -1.0;
      for (int i = 0; i < p; i++) {
        String prop = sc.nextLine();
        double d = sc.nextDouble();
        int r = sc.nextInt();
        for (int j = 0; j < r; j++) {
          String req = sc.nextLine();
        }
        double compliance = (double)r / (double)n;
        if (compliance > best_compliance || 
            (compliance == best_compliance && d < best_compliance_price)) {
          best = prop;
          best_compliance = compliance;
          best_compliance_price = d;
        }
      }
      if (t != 1)
        out.println("");
      out.println("RFP #" + t);
      out.println(best);
      t += 1;
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
