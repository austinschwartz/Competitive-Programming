import java.util.*;
import java.io.*;

class Main {
  public static long sum(long n) {
    return (n * (n + 1)) / 2;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line;
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      line = br.readLine().split(" ");
      int n = Integer.parseInt(line[0]);
      int m = Integer.parseInt(line[1]);
      long ans;
      if (n == 1 && m == 1)
        ans = 1;
      else if (n == 1)
        ans = m - 1;
      else if (n == m)
        ans = sum(m - 1);
      else
        ans = sum(m - 1) - sum(m - n - 1);
      System.out.println(ans);
    }
  }
}
