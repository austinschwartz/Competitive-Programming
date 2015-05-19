import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int T = Integer.parseInt(line);
    for (int i = 0; i < T; i++) {
      line = br.readLine();
      String[] arr = line.split(" ");
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      int c = Integer.parseInt(arr[2]);
      int[] nums = {a, b, c};
      Arrays.sort(nums);
      System.out.println("Case " + (i + 1) + ": " + nums[1]); 
    }
  }
}
