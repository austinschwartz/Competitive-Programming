import java.util.*;
import java.io.*;

class Main {
  public static int[] sums;
  public static int sums_length;

  public static int closestSum(int[] nums, int q) {
    int min_diff = Integer.MAX_VALUE;
    int closest = 0;

    for (int i = 0; i < sums_length; i++) {
      int diff = Math.abs(q - sums[i]);
      if (diff < min_diff) {
        min_diff = diff;
        closest = sums[i];
      }
    }
    return closest;
  }

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

      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          sums[sums_length++] = nums[i] + nums[j];
        }
      }

      System.out.printf("Case %d:\n", c);
      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        int q = Integer.parseInt(br.readLine());
        System.out.printf("Closest sum to %d is %d.\n", q, closestSum(nums, q));
      }
      c++;

    }
  }
}
