import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
  public static BigInteger TEN = new BigInteger("10");

  public static BigInteger reverse(BigInteger a) {
    BigInteger rev = BigInteger.ZERO;
    while (a.compareTo(BigInteger.ZERO) != 0) {
      rev = rev.multiply(TEN);
      rev = rev.add(a.mod(TEN));
      a = a.divide(TEN);
    }
    return rev;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer stk = new StringTokenizer(br.readLine());
      BigInteger a = new BigInteger(stk.nextToken());
      BigInteger b = new BigInteger(stk.nextToken());
      System.out.println(reverse(reverse(a).add(reverse(b))));
    }
  }
}
