import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      br.readLine();
      int W = Integer.parseInt(br.readLine());
      TreeSet<Integer> set = new TreeSet<Integer>();
      for (int j = 0; j < W; j++) {
        String[] arr = br.readLine().split(" ");
        int y1 = Integer.parseInt(arr[0]); // North-most row of the gap in this column
        int y2 = Integer.parseInt(arr[1]); // South-most row of the gap in this column
        set.add(Math.abs(y1 - y2));
      }
      if (set.size() == 1)
        System.out.println("yes");
      else
        System.out.println("no");
      if (i < n - 1)
        System.out.println();
    }
  }
}
