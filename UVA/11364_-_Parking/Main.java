import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      String line = br.readLine();
      String[] arr = line.split(" ");
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < n; j++) {
        int current = Integer.parseInt(arr[j]);
        if (current > max)
          max = current;
        if (current < min)
          min = current;
      }
      System.out.println(2 * (max - min));
    }
  }
}
