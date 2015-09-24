import java.util.*;
import java.io.*;

public class Main {
  public static boolean possible(int[] nums, int n, int m) {
    int[] count = new int[m];
    count[0] = 1;
    int pref_sum = 0;
    for (int i = 0; i < n; i++) {
      pref_sum += nums[i];
      pref_sum %= m;
      count[pref_sum]++;
    }

    int res = 0;
    for (int mod = 0; mod < m; mod++) {
      res += (int)count[mod] * (count[mod] - 1)/2;
    }

    System.out.println(res);
    return (res > 0);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int[] nums = new int[n];

    String[] numStrings = br.readLine().split(" ");
    for (int i = 0; i < n; i++)
      nums[i] = Integer.parseInt(numStrings[i]);
  
    System.out.println(possible(nums, n, m) ? "YES" : "NO");  
  }
}
