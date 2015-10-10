import java.util.*;
import java.io.*;

class Main {
  public static int[] set;
  public static void subset(int[] nums, int n, int[] s, int sindex, int index, int k) {
    if (index > n)
      return;

    if (k == 0) {
      set = Arrays.copyOf(s, 6);
      Arrays.sort(set);
      for (int i = 0; i < 5; i++) {
        System.out.print(set[i] + " " );
      }
      System.out.println(set[5]);
      return;
    }
    if (index < n)
      s[sindex] = nums[index];
    subset(nums, n, s, sindex+1, index+1, k-1);
    subset(nums, n, s, sindex, index+1, k);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int x = 0;
    while ((line = br.readLine()) != null && !line.equals("0")) {
      if (x > 0)
        System.out.println();
      String[] s = line.split(" ");
      int k = Integer.parseInt(s[0]);
      int[] nums = new int[k];
      for (int i = 1; i <= k; i++) {
        nums[i-1] = Integer.parseInt(s[i]);
      }
      int[] S = new int[6];
      subset(nums, k, S, 0, 0, 6);
      x++;
    }
  }
}
