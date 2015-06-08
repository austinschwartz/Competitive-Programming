import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      int n = Integer.parseInt(line);
      if (n == 0)
        return;
      double[] a = new double[n];
      double total = 0.0;
      double min = Double.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        double x = Double.parseDouble(br.readLine());
        a[i] = x;
        total += x;
        if (x < min)
          min = x;
      }
      double avg = total / n;
      double negcost = 0.0;
      double poscost = 0.0;
      for (int i = 0; i < n; i++) {
        double diff = Math.abs((double) (long)((a[i] - avg) * 100.0) / 100.0);
        if (a[i] > avg)
          poscost += diff;
        else if (avg > a[i])
          negcost += diff;
      }
      if (poscost <  negcost)
        System.out.printf("$%.2f\n", poscost);
      else
        System.out.printf("$%.2f\n", negcost);
    }
  }
}
