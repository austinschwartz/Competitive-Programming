import java.io.*;
import java.util.*;

class Main {
  static int[] nums;
  public static void swap(int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  public static void quicksort(int low, int high) {
    int i = low;
    int j = high;
    int pivot = nums[low + (high - low)/2];
    while (i <= j) {
      while (nums[i] < pivot) i++;
      while (nums[j] > pivot) j--;
      if (i <= j) {
        swap(i, j);
        i++;
        j--;
      }
    }
    if (low < j) quicksort(low, j);
    if (high > i) quicksort(i, high);
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
      quicksort(0, arr.length - 1);
      System.out.println(Arrays.toString(nums));
    }
  }
}
