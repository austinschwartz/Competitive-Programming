import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
  public static final BigInteger TWENTY_SIX = new BigInteger("26");
  public static BigInteger toNumber(String l) {
    BigInteger a = new BigInteger("0");
    for (int i = 0; i < l.length(); i++) {
      a = a.multiply(TWENTY_SIX);
      a = a.add(BigInteger.valueOf((l.charAt(i) - 'a' + 1)));
    }
    return a;
  }

  public static String toWord(BigInteger a) {
    StringBuilder sb = new StringBuilder();
    while (a.compareTo(BigInteger.ZERO) != 0) {
      sb.append((char)('a' + a.subtract(BigInteger.ONE).mod(TWENTY_SIX).intValue()));
      a = a.subtract(BigInteger.ONE).divide(TWENTY_SIX);
    }
    sb.reverse();
    return sb.toString();
  }
  
  public static String toPrintableString(BigInteger a) {
    StringBuilder sb = new StringBuilder();
    while (a.compareTo(BigInteger.ZERO) != 0) {
      sb.append(a.mod(new BigInteger("10")));
      a = a.divide(new BigInteger("10"));
    }
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).equals("*")) {
      if (Character.isDigit(line.charAt(0))) {
        BigInteger a = new BigInteger(line);
        System.out.println(toWord(a) + " " + a);
      } else {
        System.out.println(line + " " + toPrintableString(toNumber(line)));
      }
    }
  }
}
