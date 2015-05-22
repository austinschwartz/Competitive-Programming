import java.util.*;
import java.io.*;

class Main {
  public static boolean jolly(int[] nums) {
    if (nums.length == 1)
      return true;
    int[] absvals = new int[nums.length-1];
    for (int i = 0; i < nums.length - 1; i++) {
      absvals[i] = Math.abs(nums[i+1] - nums[i]);
    }
    Arrays.sort(absvals);
    if (absvals[0] != 1)
      return false;
    if (absvals[absvals.length - 1] != absvals.length)
      return false;
    for (int j = 0; j < absvals.length - 1; j++) {
      if (absvals[j] == absvals[j+1])
        return false;
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      int[] nums = new int[arr.length-1];
      for (int i = 1; i < arr.length; i++) {
        nums[i-1] = Integer.parseInt(arr[i]);
      }
      System.out.println(jolly(nums) ? "Jolly" : "Not jolly");
    }
  }
}
