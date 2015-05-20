import java.util.*;
import java.io.*;

class Main {
  public static int GCD(int a, int b) {
    while (a != 0 && b != 0) {
      int c = b;
      b = a % b;
      a = c;
    }
    return a + b;
  }

  public static int recursiveGCD(int a, int b) { 
    if (a == 0 || b == 0) return a + b;
    return recursiveGCD(b, a % b);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] arr = br.readLine().split(" ");
      int[] nums = new int[arr.length];
      int length = arr.length;
      for (int j = 0; j < length; j++)  {
        nums[j] = Integer.parseInt(arr[j]);
      }
      int max = 0;
      for (int k = 0; k < length; k++) {
        for (int l = 0; l < length; l++) {
          if (k != l)
            max = Math.max(max, GCD(nums[k], nums[l]));
        }
      }
      System.out.println(max);
    }
  }
}
