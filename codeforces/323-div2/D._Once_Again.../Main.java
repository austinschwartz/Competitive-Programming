import java.util.*;
import java.io.*;

public class Main {
  public static int[] memo;
  public static int longestNonDecreasing(int[] nums, int n) {
    return(maxi);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int T = Integer.parseInt(line[1]);
    int nums[] = new int[n * T];
    memo = new int[n * T];
    line = br.readLine().split(" ");
    int last = 0;
    for (int i = 0; i < T; i++) {
      for (int j = 0; j < n; j++) {
        nums[last] = Integer.parseInt(line[j]);
        last++;
      }
    }
    System.out.println(longestNonDecreasing(nums, n * T));
  }
}
