import java.util.*;
import java.io.*;

class Main {
  static int p,q,r,s,t,u;
  public static double f(double x) {
    return p * Math.pow(Math.E, -1 * x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u;
  }
  public static double bisection() {
    double low = 0;
    double high = 1;
    while (low + 1e-7 < high) {
      double x = (low + high)/2;
      if (f(low) * f(x) <= 0) {
        high = x;
      } else {
        low = x;
      }
    }
    return (high + low)/2;
  }
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {
      p = in.nextInt();
      q = in.nextInt();
      r = in.nextInt();
      s = in.nextInt();
      t = in.nextInt();
      u = in.nextInt();
      if (f(0) * f(1) > 0)
        System.out.println("No solution");
      else 
        System.out.printf("%.4f\n", bisection());
    }
  }
}
