import java.util.*;
import java.io.*;

class Main {
  public static long maxProduct(int[] nums, int n) {
    long max = 0;
    for (int i = 0; i < n; i++) {
      long prod = 1;
      for (int j = i; j < n; j++) {
        prod *= nums[j];
        max = Math.max(prod, max);
      }
    }
    return max;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int z = 0;
    while ((line = br.readLine()) != null) {
      int n = Integer.parseInt(line);
      String[] s = br.readLine().split(" ");
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(s[i]);
      }
      System.out.printf("Case #%d: The maximum product is %d.\n\n", z + 1, maxProduct(nums, n));
      br.readLine();
      z++;
    }
  }
}
