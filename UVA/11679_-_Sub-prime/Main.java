import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).equals("0 0")) {
      boolean possible = true;
      String[] arr = line.split(" ");
      int B = Integer.parseInt(arr[0]);
      int N = Integer.parseInt(arr[1]);
      arr = br.readLine().split(" ");
      int[] R = new int[B];
      for (int i = 0; i < B; i++)
        R[i] = Integer.parseInt(arr[i]);
      for (int j = 0; j < N; j++) {
        arr = br.readLine().split(" ");
        int D = Integer.parseInt(arr[0]);
        int C = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);
        R[D-1] -= V;
        R[C-1] += V;
      }
      for (int k = 0; k < B; k++)
        if (R[k] < 0)
          possible = false;
      if (possible)
        System.out.println("S");
      else
        System.out.println("N");
    }
  }
}
