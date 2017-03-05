import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int n;
  public static int[] x, v;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt(); // friends
    x = new int[n]; // coords
    v = new int[n]; // speeds
    int max = -1, min = Integer.MAX_VALUE;
    int average = 0;
    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      max = Math.max(max, x[i]);
      min = Math.min(min, x[i]);
    }
    int weights = 0;
    for (int i = 0; i < n; i++) {
      v[i] = sc.nextInt();
      average += (x[i]);
      weights += v[i];
    }
    average /= (n);
    out.printf("%.12f\n", time(tsearch(min, max)));
    out.close();
  }
  public static double eps = (1e-15);

  public static double tsearch(double left, double right) {
    while (true) {
      if (Math.abs(right - left) < eps)
        return (left + right)/2;

      double leftThird = left + (right - left)/3;
      double rightThird = right - (right - left)/3;
      
      if (time(leftThird) > time(rightThird))
        left = leftThird;
      else
        right = rightThird;
    }
  }

  public static double findMin(double min, double max, double step) {
    double minValue = time(min);

    for (double i = min; i <= max; i += (max - min)) {
        double currEval = time(i);
        if (currEval < minValue) {
            minValue = currEval;
        }
    }

    return minValue;
}

  public static double time(double y) {
    double ret = 0;
    for (int i = 0; i < n; i++) {
      double g = (double)Math.abs(y - (double)x[i]) / v[i];
      ret = Math.max(ret,g);
    }
    return ret;
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
