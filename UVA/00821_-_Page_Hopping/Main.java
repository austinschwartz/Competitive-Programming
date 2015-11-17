import java.util.*;
import java.io.*;

class Main {
  public static class Pair {
    public int a, b;
    public Pair(Integer a, Integer b) {
      this.a = a;
      this.b = b;
    }
  }
  public static double avgDist(List<Pair> pairs, int N) {
    long[][] dist = new long[N][N];
    for (int i = 0; i < N; i++)
      Arrays.fill(dist[i], Integer.MAX_VALUE - 1);

    for (int i = 0; i < N; i++)
      dist[i][i] = 0;

    for (Pair pair : pairs) {
      int i = pair.a - 1;
      int j = pair.b - 1;
      dist[i][j] = 1;
    }

    for (int k = 0; k < N; k++)
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          if (dist[i][j] > dist[i][k] + dist[k][j])
            dist[i][j] = dist[i][k] + dist[k][j];

    int sum = 0;
    double total = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (dist[i][j] < 1 << 30 && dist[i][j] != 0) {
          sum += dist[i][j];
          total++;
        }
      }
    }
    return sum / total;
  }
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int a, b, i = 1;
    while (true) {
      List<Pair> pairs = new ArrayList<Pair>();
      a = sc.nextInt();
      b = sc.nextInt();
      if (a  == 0 && b == 0) return;
      pairs.add(new Pair(a, b));
      int max = 0;
      while (true) {
        a = sc.nextInt();
        b = sc.nextInt();
        if (a == 0 && b == 0) break;
        pairs.add(new Pair(a, b));
        max = Math.max(max, Math.max(a, b));
      }
      System.out.printf("Case %d: average length between pages = %.3f clicks\n", i, avgDist(pairs, max));
      i++;
    }
  }
}
