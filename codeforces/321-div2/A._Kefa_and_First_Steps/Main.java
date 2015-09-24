import java.util.*;
import java.io.*;

public class Main {
  public static int[] memo;

  public static int subSegment(int[] nums, int n) {
    int max = 1;
    memo[0] = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] >= nums[i-1])
        memo[i] = memo[i-1] + 1;
      else
        memo[i] = 1;
      if (memo[i] > max)
        max = memo[i];
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n];
    memo = new int[n];
    StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt((String)tk.nextElement());
    }
    System.out.println(subSegment(nums, n));
  }
}
