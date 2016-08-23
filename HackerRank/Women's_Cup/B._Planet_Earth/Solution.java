import java.util.*;
import java.io.*;

class Solution {
  public static long f(long N, long T) {
    if (T == 1) return 0;
    if (N == 1) return T - 1;
    if (N > T) return N;
    if (N % 2 == 0)
      return T + (long)(N/2);
    return 1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] s = line.split(" ");
      long N = Long.parseLong(s[0]);
      long T = Long.parseLong(s[1]);
      int d = 0;
      int c = 0;
      long change = 1;
      boolean decreasing = true;
      for (long i = 1; i <= N; i++) {
        if (decreasing) {
          T -= change;
          d += change;
        }
        else {
          T += change;
          c += change;
        }
        if (i % 2 == 0) {
          change++;
          decreasing = !decreasing;
        }
      }
      System.out.println(N + " " + T + " - " +d + " " + c);
      System.out.println(T);
      
      //System.out.println(f(N, T));
    }
  }
}
