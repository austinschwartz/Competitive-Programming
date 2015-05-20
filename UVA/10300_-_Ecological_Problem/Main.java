import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int n = Integer.parseInt(line);
    for (int i = 0; i < n; i++) {
      int f = Integer.parseInt(br.readLine());
      int burden = 0;
      for (int j = 0; j < f; j++) {
        String[] arr = br.readLine().split(" ");
        int size = Integer.parseInt(arr[0]);
        int animals = Integer.parseInt(arr[1]);
        int friendliness = Integer.parseInt(arr[2]);
        burden += (size * friendliness);
      }
      System.out.println(burden);
    }
  }
}
