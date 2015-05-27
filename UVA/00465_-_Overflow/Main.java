import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    BigInteger max = new BigInteger(Integer.MAX_VALUE + "");
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      System.out.println(line);
      BigInteger a = new BigInteger(arr[0]);
      BigInteger b = new BigInteger(arr[2]);
      if (a.compareTo(max) == 1)
        System.out.println("first number too big");
      if (b.compareTo(max) == 1)
        System.out.println("second number too big");
      BigInteger c = new BigInteger("0");
      if (arr[1].equals("+"))
        c = a.add(b);
      else if (arr[1].equals("*"))
        c = a.multiply(b);
      if (c.compareTo(max) == 1)
        System.out.println("result too big");

    }
  }
}
