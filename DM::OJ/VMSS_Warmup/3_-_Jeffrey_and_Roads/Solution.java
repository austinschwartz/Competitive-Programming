import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

  public static Line pointsToLine(Point p1, Point p2) {
    int a, b, c;
    if (p1.x == p2.x) { // Vertical line
      return new Line(1, 0, -1 * p1.x);
    } else {
      a = (-1) * (p1.y - p2.y)/(p1.x - p2.x);
      b = 1;
      c = (-1) * (a * p1.x) - p1.y;
      return new Line(a, b, c); 
    }
  }

  public static boolean areParallel(Line l1, Line l2) {
    return (Math.abs(l1.a - l2.a) == 0 && Math.abs(l1.b - l2.b) == 0);
  }

  public static boolean areIntersect(Line l1, Line l2) {
    if (areParallel(l1, l2)) 
      return false;
    int x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);
    int y;
    if (Math.abs(l1.b) != 0)
      y = (-1) * (l1.a * x + l1.c);
    else
      y = (-1) * (l2.a * x + l2.c);
    System.out.println(x + " " + y);
    return true;
  }

  public static class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static class Line {
    public int a;
    public int b;
    public int c;
    public Line(int A, int B, int C) {
      this.a = A;
      this.b = B;
      this.c = C;
    }
    @Override
    public String toString() {
      return a + " " + b + " " + c;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] coords = br.readLine().split(" ");
    int xh = Integer.parseInt(coords[0]);
    int yh = Integer.parseInt(coords[1]);
    int xs = Integer.parseInt(coords[2]);
    int ys = Integer.parseInt(coords[3]);
    Point home = new Point(xh, xh);
    Point school = new Point(xs, ys);
    Line homeToSchool = pointsToLine(home, school);
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    for (int i = 0; i < N; i++) {
      String[] lineCoords = br.readLine().split(" ");
      int A = Integer.parseInt(lineCoords[0]);
      int B = Integer.parseInt(lineCoords[1]);
      int C = Integer.parseInt(lineCoords[2]);
      Line line = new Line(A, B, C);
      if (areIntersect(line, homeToSchool))
        count++;
    }
    System.out.println(count);

  }
}
