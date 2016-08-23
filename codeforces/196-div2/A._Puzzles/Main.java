import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] x = br.readLine().split(" ");
    int n = Integer.parseInt(x[0]);
    int m = Integer.parseInt(x[1]);
    int[] nums = new int[m];
    x = br.readLine().split(" ");
    for (int i = 0; i < m; i++)
      nums[i] = Integer.parseInt(x[i]);

    Arrays.sort(nums);
    int best = Integer.MAX_VALUE;
    for (int k = 1; k <= m - n; k++)
      best = Math.min(best, nums[k + n - 1] - nums[k]);

    System.out.println(best);
  }
}
