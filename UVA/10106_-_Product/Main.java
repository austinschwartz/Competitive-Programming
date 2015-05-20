import java.util.*;
import java.io.*;
import java.math.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      BigInteger X = new BigInteger(line);
      BigInteger Y = new BigInteger(br.readLine());
      System.out.println(X.multiply(Y));
    }
  }
}
