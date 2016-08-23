import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int t = Integer.parseInt(line[1]);
    if (n < 30) {
      for (long i = (long)Math.pow(10, (n - 1)); i < (long)Math.pow(10, n); i += 1) {
        if (i % t == 0) {
          System.out.println(i);
          return;
        }
      }
    } else {
      BigInteger ten = BigInteger.valueOf(10);
      for (BigInteger i = ten.pow(n - 1); i.compareTo(ten.pow(n)) == -1; i = i.add(BigInteger.ONE)) {
        if (i.mod(BigInteger.valueOf(t)).equals(BigInteger.ZERO)) {
          System.out.println(i);
          return;
        }
      }
    }
    System.out.println(-1);
  }
}
