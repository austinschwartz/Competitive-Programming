import java.util.*;
import java.io.*;

public class Main {
  public static int slope(int[] p1, int[] p2) {
    if (p2[0] - p1[0] == 0) return 0;
    return Math.abs((p2[1] - p1[1])/(p2[0] - p1[0]));
  }
  
  public static int area(int[][] coords, int n) {
    if (n <= 1) return -1;
    if (n == 2) {
      int slope1 = slope(coords[0], coords[1]);
      if (slope1 == 0) 
        return -1;
      else
        return Math.abs((coords[1][1] - coords[0][1]) * (coords[1][0] - coords[0][0]));
    }
    int slope1 = slope(coords[0], coords[1]);
    if (slope1 != 0)
        return Math.abs((coords[1][1] - coords[0][1]) * (coords[1][0] - coords[0][0]));

    int slope2 = slope(coords[1], coords[2]);
    if (slope2 != 0)
        return Math.abs((coords[2][1] - coords[1][1]) * (coords[2][0] - coords[1][0]));
  
    int slope3 = slope(coords[0], coords[2]);
    if (slope3 != 0)
        return Math.abs((coords[2][1] - coords[0][1]) * (coords[2][0] - coords[0][0]));

    if (n == 4) {
      int slope4 = slope(coords[0], coords[3]);
      if (slope4 != 0)
          return Math.abs((coords[3][1] - coords[0][1]) * (coords[3][0] - coords[0][0]));
      int slope5 = slope(coords[1], coords[3]);
      if (slope5 != 0)
          return Math.abs((coords[3][1] - coords[1][1]) * (coords[3][0] - coords[1][0]));
      int slope6 = slope(coords[2], coords[3]);
      if (slope6 != 0)
          return Math.abs((coords[3][1] - coords[2][1]) * (coords[3][0] - coords[2][0]));
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] coords = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] sp = br.readLine().split(" ");
      coords[i][0] = Math.abs(Integer.parseInt(sp[0]));
      coords[i][1] = Math.abs(Integer.parseInt(sp[1]));
    }
    System.out.println(area(coords, n));
  }
}
