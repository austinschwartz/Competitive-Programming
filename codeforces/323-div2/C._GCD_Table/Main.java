import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] line = br.readLine().split(" ");
    int[] nums = new int[N*N];
    for (int i = 0; i < N*N; i++) {
      nums[i] = Integer.parseInt(line[i]);
    }
    System.out.println(Arrays.toString(nums));
  }
}
