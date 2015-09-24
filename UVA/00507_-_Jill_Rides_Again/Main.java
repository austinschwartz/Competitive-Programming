import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int b = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < b; i++) {
      int s = Integer.parseInt(br.readLine().trim());
      int[] stops = new int[s-1];
      for (int j = 0; j < s - 1; j++) {
        stops[j] = Integer.parseInt(br.readLine().trim());
      }
      int start = 0, startf = 0, end = -1;
      int sum = 0, ans = 0;
      for (int j = 0; j < s - 1; j++) {
        sum += stops[j];
        if (sum < 0) {
          sum = 0;
          start = j + 1;
        }
        if (sum > ans || (sum == ans && j-start > end - start)) {
          ans = sum;
          end = j;
          startf = start;
        }
      }
      if (ans == 0)
        System.out.println("Route " + (i + 1) + " has no nice parts");
      else
        System.out.println("The nicest part of route " + (i + 1) + 
            " is between stops " + (startf+1) + " and " + (end + 2));
    }
  }
}
