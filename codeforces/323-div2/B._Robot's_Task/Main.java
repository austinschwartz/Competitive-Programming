import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(line[i]);
    }
    int highest = 0;
    int dirchanges = 0;

    while (highest < n) {
      for (int i = 0; i < n; i++) {
        if (arr[i] <= highest && arr[i] != -1) {
          highest++;
          arr[i] = -1;
        }
      }
      if (highest < n) {
        dirchanges++;
        for (int i = n - 1; i >= 0; i--) {
          if (arr[i] <= highest && arr[i] != -1) {
            highest++;
            arr[i] = -1;
          }
        }
      }
      if (highest < n) {
        dirchanges++;
      }
    }
    System.out.println(dirchanges);
  }
}
