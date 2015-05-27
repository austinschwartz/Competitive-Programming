import java.util.*;
import java.io.*;
import java.math.BigDecimal;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      StringTokenizer stk = new StringTokenizer(line);
      BigDecimal a = new BigDecimal(stk.nextToken());
      int n = Integer.parseInt(stk.nextToken());
      a = a.pow(n);
      String result = a.stripTrailingZeros().toPlainString();
      if (result.charAt(0) == '0')
        System.out.println(result.substring(1));
      else
        System.out.println(result);
    }
  }
}
