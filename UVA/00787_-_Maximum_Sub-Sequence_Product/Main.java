import java.util.*;
import java.io.*;
import java.math.*;

class Main {
  public static BigInteger maxSubProduct(List<BigInteger> nums) {
    BigInteger max = nums.get(0);
    
    for (int i = 0; i < nums.size(); i++) {
      BigInteger current = nums.get(i);
      max = max.max(current);
      for (int j = i + 1; j < nums.size(); j++) {
        current = current.multiply(nums.get(j));
        max = max.max(current);
      }
    }

    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    StringTokenizer tk;
    while ((line = br.readLine()) != null) {
      tk = new StringTokenizer(line, " ");
      List<BigInteger> lst = new ArrayList<BigInteger>();
      while (tk.hasMoreElements()) {
        String ele = (String)tk.nextElement();
        if (!ele.equals("-999999"))
          lst.add(new BigInteger(ele));
      }
      System.out.println(maxSubProduct(lst));
    }
  }
}
