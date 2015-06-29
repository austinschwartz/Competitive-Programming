import java.util.*;
import java.io.*;

class Main {

  static List<Edge> edgeList;
  static int N;
  static int[] pset;
  static int[] rank;

  static class Edge {
    double w;
    double from;
    double to;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      br.readLine();
      int n = Integer.parseInt(br.readLine());
      for (int j = 0; j < n; j++) {
        String line = br.readLine();
        double x1 = Double.parseDouble(line.split(" ")[0]);
        double x2 = Double.parseDouble(line.split(" ")[1]);
        System.out.printf("%f %f\n", x1, x2);
      }

    }
  }
}
