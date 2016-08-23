import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long num = (long)(1000000007);
    BigInteger a = BigInteger.valueOf(3).pow(3 * n);
    BigInteger b = BigInteger.valueOf(7).pow(n);
    System.out.println(a.subtract(b).mod(BigInteger.valueOf(num)));
  }
}
