import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int t = Integer.parseInt(line);
    for (int i = 0; i < t; i++) {
      line = br.readLine();
      String[] nums = line.split(" ");
      int n = Integer.parseInt(nums[0]);
      int m = Integer.parseInt(nums[1]);
      System.out.println((int)(Math.ceil((n - 2)/3.0) * Math.ceil((m - 2)/3.0)));
    }
  }
}
