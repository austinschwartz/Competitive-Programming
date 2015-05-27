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
      int max_so_far = 0;
      int max_ending_here = 0;
      for (int k = 0; k < s - 1; k++) {
        max_ending_here += stops[k];
        if (max_ending_here < 0) {
          max_ending_here = 0;
          start = k;
        }
        if (max_so_far < max_ending_here) {
          max_so_far = max_ending_here;
          end = k;
        }
      }
      System.out.println(Arrays.toString(stops));
      System.out.println(max_so_far);
      if (max_so_far == 0)
        System.out.println("Route " + (i + 1) + " has no nice parts");
      else
        System.out.println("The nicest part of route " + (i+1) + " is between stops " + (start + 2) + " and " + (end + 2));
    }
  }
}
