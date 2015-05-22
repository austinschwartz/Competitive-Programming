import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 1; i <= T; i++) {
      String[] arr = br.readLine().split(" ");
      int N = Integer.parseInt(arr[0]);
      int max = -1;
      for (int j = 1; j <= N; j++)
        max = Math.max(Integer.parseInt(arr[j]), max);
      System.out.println("Case " + i + ": " + max);
    }  
  }
}
