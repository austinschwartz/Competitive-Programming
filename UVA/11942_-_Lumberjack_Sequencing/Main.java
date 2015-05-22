import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Lumberjacks:");
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      boolean sorted = true;
      boolean lefttoright = true;
      String[] arr = br.readLine().split(" ");
      if (arr.length > 1) {
        int prev = Integer.parseInt(arr[0]);
        int curr = Integer.parseInt(arr[1]);
        if (prev > curr)
          lefttoright = false;
        for (int j = 2; j < arr.length && sorted; j++) {
          curr = Integer.parseInt(arr[j]);
          if ((lefttoright && curr < prev) || (!lefttoright && curr > prev))
            sorted = false;
          prev = curr;
        }
        System.out.println(sorted ? "Ordered" : "Unordered");
      } else 
        System.out.println("Ordered");
    }
  }
}
