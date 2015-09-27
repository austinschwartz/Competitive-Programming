import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String[] nl = br.readLine().split(" ");
      int size = Integer.parseInt(nl[0]);
      int[] nums = new int[size];
      for (int j = 1; j < size+1; j++) {
        nums[j-1] = Integer.parseInt(nl[j]);
      }
      Arrays.sort(nums);
      if (nums.length % 2 != 0)
        System.out.printf("Case %d: %d\n", (i + 1), nums[nums.length / 2]);
      else
        System.out.printf("Case %d: %d\n", (i + 1), 0);
    }
  }
}
