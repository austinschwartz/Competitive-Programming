import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int x = 0; x < N; x++) {
      int size = Integer.parseInt(br.readLine());
      String[] temp = br.readLine().split(" ");
      int[] arr = new int[size];
      for (int v = 0; v < size; v++) {
        arr[v] = Integer.parseInt(temp[v]);
      }

      int count = 0;
      for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
          if (arr[j] < arr[i])
           count++; 
        }
      }
      System.out.printf("Optimal train swapping takes %d swaps.\n", count);
    }
  }
}
