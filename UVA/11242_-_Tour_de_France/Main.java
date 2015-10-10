import java.util.*;
import java.io.*;

class Main {
  public static double maxSpread(double[] d) {
    double max = -1;
    for (int i = 0; i < d.length - 1; i++) {
      max = Math.max(max, d[i+1] / d[i]);
    }
    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String[] s;
    while ((line = br.readLine()) != null && !line.equals("0")) {
      s = line.split(" ");
      int f = Integer.parseInt(s[0]);
      int r = Integer.parseInt(s[1]);
      int[] fs = new int[f];
      int[] rs = new int[r];

      s = br.readLine().split(" ");
      for (int i = 0; i < f; i++) 
        fs[i] = Integer.parseInt(s[i]);

      s = br.readLine().split(" ");
      for (int i = 0; i < r; i++)
        rs[i] = Integer.parseInt(s[i]);

      double[] d = new double[f * r];
      int x = 0;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < f; j++) {
          d[x] = (double)rs[i] / (double)fs[j];
          x++;
        }
      }
      Arrays.sort(d);
      System.out.printf("%.2f\n", maxSpread(d));
    }
  }
}
