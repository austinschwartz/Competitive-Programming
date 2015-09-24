import java.util.*;
import java.io.*;

public class Main {
  public static List<Integer> list;
  public static int[] nums;
  public static int total;
  public static int n;
  public static void use(int a) {
    for (int i = 0; i < n; i++) {
      if (nums[i] % a == 0) {
        list.add(nums[i]);
        nums[i] = -1;
        total--;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = i + 1;
    list = new ArrayList<Integer>();
    total = n;
    int current = 2;
    while (total > 1) {
      use(current);
      current++;
    }
    System.out.println(list.size());
    for (int j = 0; j < list.size() - 1; j++) {
      System.out.print(list.get(j) + " ");   
    }
    System.out.print(list.get(list.size() - 1) + "\n");
  }
}
