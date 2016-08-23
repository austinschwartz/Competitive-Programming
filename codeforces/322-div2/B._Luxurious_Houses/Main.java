import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] line = br.readLine().split(" ");
    int[] houses = new int[N];
    int[] maxes = new int[N];
    int[] res = new int[N];
    for (int i = 0; i < N; i++) {
      houses[i] = Integer.parseInt(line[i]);
    }
    maxes[N-1] = houses[N-1];
    int max = maxes[N-1];
    for (int i = N-2; i >= 0; i--) {
      maxes[i] = Math.max(max, houses[i]);
      if (maxes[i] > max)
        max = maxes[i];
    }
    for (int i = N-1; i >= 0; i--) {
      res[i] = maxes[i] - houses[i] + 1;
    }
    for (int i = 0; i < N-1; i++) {
      System.out.print(res[i] + " ");
    }
    System.out.println(res[N-1]);
  }
}
