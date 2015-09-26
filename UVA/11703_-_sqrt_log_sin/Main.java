import java.util.*;
import java.io.*;

class Main {
  public static int[] memo;
  public static int x(int n) {
    if (memo[n] != -1)
      return memo[n];
    int first = x((int)Math.floor(n - Math.sqrt(n)));
    int second = x((int)Math.floor(Math.log(n)));
    int third = x((int)Math.floor(n * Math.sin(n) * Math.sin(n)));
    memo[n] = (first + second + third) % 1000000;
    return memo[n];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    memo = new int[1000000];
    Arrays.fill(memo, -1);
    memo[0] = 1;
    while (true) {
      int N = Integer.parseInt(br.readLine());
      if (N == -1)
        return;
      else
        System.out.println(x(N));
    }
  }
}
