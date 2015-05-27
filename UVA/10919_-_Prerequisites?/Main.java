import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {
      boolean hasprereqs = true;
      int k = in.nextInt();
      if (k == 0)
        break;
      int m = in.nextInt();
      Set<Integer> taking = new HashSet<Integer>();
      for (int i = 0; i < k; i++) {
        taking.add(in.nextInt());
      }
      for (int j = 0; j < m; j++) {
        int c = in.nextInt();
        int r = in.nextInt();
        int cur = 0;
        for (int l = 0; l < c; l++) {
          int course = in.nextInt();
          if (taking.contains(course))
            cur++;
        }
        if (cur < r)
          hasprereqs = false;
      }
      System.out.println(hasprereqs ? "yes" : "no");
    }
  }
}
