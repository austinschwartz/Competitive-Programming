import java.io.*;
import java.util.*;

public class Main {
  public static int[] memo;
  public static int[][] triangle;

  public static void main(String[] args) throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    triangle = new int[n][n];
    int max = -1;
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < line.length; j++) {
        int num = Integer.parseInt(line[j]);
        int res = num;
        if (i > 0) {
        // left
          if (j > 0 && triangle[i-1][j-1] > triangle[i-1][j])
            res = num + triangle[i-1][j-1];
          else
            res = num + triangle[i-1][j];
        }
        if (res > max)
          max = res;
        triangle[i][j] = res;
      }
    }
    System.out.println(max);
  }
}
