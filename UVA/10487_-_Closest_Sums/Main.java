import java.util.*;
import java.io.*;

class Main {
  public static int[] sums;
  public static int sums_length;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;
    int c = 1;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      int[] nums = new int[n];

      for (int i = 0; i < n; i++)
        nums[i] = Integer.parseInt(br.readLine());
      Arrays.sort(nums);

      sums = new int[nums.length * nums.length + 100];
      sums_length = 0;

      for (int i = 0; i < nums.length; i++)
        for (int j = i + 1; j < nums.length; j++)
          sums[sums_length++] = nums[i] + nums[j];

      System.out.printf("Case %d:\n", c);

      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        int q = Integer.parseInt(br.readLine());
        int min_diff = Integer.MAX_VALUE;
        int closest = 0;

        for (int j = 0; j < sums_length; j++) {
          int diff = Math.abs(q - sums[j]);
          if (diff < min_diff) {
            min_diff = diff;
            closest = sums[j];
          }
        }
        System.out.printf("Closest sum to %d is %d.\n", q, closest);
      }
      c++;

    }
  }
}
