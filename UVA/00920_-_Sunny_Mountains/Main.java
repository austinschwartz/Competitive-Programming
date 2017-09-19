import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static double hypot(double dx, double dy) {
    return Math.sqrt(dx * dx + dy * dy);
  }
  public static class Point {
    double x, y;
    public Point(double x, double y) {this.x = x; this.y = y;}
    public Point(int x, int y) {this.x = (double)x; this.y = (double)y;}
    public static double dist(Point a, Point b) {
      return hypot(a.x - b.x, a.y - b.y);
    }
    public double dist(Point p) {
      return dist(p, this);
    }
  }
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int C = sc.nextInt();
    for (int i = 0; i < C; i++) {
      int N = sc.nextInt();
      double res = 0;
      Point[] points = new Point[N];
      for (int j = 0; j < N; j++) {
        points[j] = new Point(sc.nextInt(), sc.nextInt());
      }
      Arrays.sort(points, new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
          return Double.compare(b.x, a.x);
        }
      });
      res += points[0].dist(points[1]);
      double cur_y = points[1].y;
      for (int j = 2; j < N; j++) {
        Point p = points[j];
        Point pp = points[j - 1];
        if (p.y <= cur_y) continue;
        double slope = (pp.y - p.y) / (pp.x - p.x);
        double b = p.y - (slope)*p.x;
        double new_y = cur_y;
        double new_x = (new_y - b) / slope;
        res += p.dist(new Point(new_x, new_y));
        cur_y = p.y;
      }
      out.println(String.format("%.2f", res));
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
