import java.util.*;
import java.io.*;

class Solution {
  public static String maxArrays(int[] nums, int n) {
    int maxContinuous = 0;
    int maxNonCont = 0;

    int maxEndingHere = 0;
    int maxSoFar = 0;
    int minNegative = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxEndingHere = Math.max(0, maxEndingHere + nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
      if (nums[i] > 0)
        maxNonCont += nums[i];
      else {
        minNegative = Math.max(nums[i], minNegative);
      }
    }
    maxContinuous = maxSoFar;
    if (maxNonCont == 0)
      maxNonCont = minNegative;
    if (maxContinuous == 0)
      maxContinuous = minNegative;
    return String.format("%d %d", maxContinuous, maxNonCont);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int T = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine().trim());
      int[] nums = new int[N];
      String[] s = br.readLine().split(" ");
      for (int j = 0; j < N; j++)
        nums[j] = Integer.parseInt(s[j]);
      System.out.println(maxArrays(nums, N));
    }
  }
}
