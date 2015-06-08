import java.io.*;
import java.util.*;

class Main {
  static int[] nums;
  public static void swap(int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  public static void bubblesort() {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - 1; j++) {
        if (nums[j] > nums[j + 1])
          swap(j, j + 1);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      nums = new int[arr.length];
      for (int i = 0; i < arr.length; i++)
        nums[i] = Integer.parseInt(arr[i]);
      System.out.println(Arrays.toString(nums));
      bubblesort();
      System.out.println(Arrays.toString(nums));
    }
  }
}
