import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 1; i <= T; i++) {
      int high = 0;
      int low = 0;
      int N = Integer.parseInt(br.readLine());
      String[] arr = br.readLine().split(" ");
      int prev = Integer.parseInt(arr[0]);
      int curr;
      for (int j = 1; j < arr.length; j++) {
        curr = Integer.parseInt(arr[j]);
        if (prev > curr) low++;
        if (curr > prev) high++;
        prev = curr;
      }
      System.out.println("Case " + i + ": " + high + " " + low);
    }
  }
}
