import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
  static BigInteger[] memo = new BigInteger[82];
  static int k = 2;
  public static void main(String[] args) throws Exception {
    memo[0] = BigInteger.ZERO;
    memo[1] = BigInteger.ONE;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    while ((N = Integer.parseInt(br.readLine())) != 0) {
      while ((N + 1) >= k) {
        memo[k] = memo[k - 1].add(memo[k - 2]);
        k++;
      }
      System.out.println(memo[N+1]);
    }
  }
}
