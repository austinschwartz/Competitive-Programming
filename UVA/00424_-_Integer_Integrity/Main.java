import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    BigInteger a = new BigInteger("0");
    while (!(line = br.readLine()).equals("0")) {
      BigInteger b = new BigInteger(line);
      a = a.add(b);
    }
    System.out.println(a.toString());
  }
}
