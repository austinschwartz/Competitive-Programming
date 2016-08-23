import java.util.*;
import java.io.*;

class Main {
  public static boolean hasNegative(int[] arr) {
    boolean x = false;
    for (int i = 0; i < arr.length && x == false; i++)
      if (arr[i] < 0) x = true;
    return x;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] banks = new int[n];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      banks[i] = Integer.parseInt(line[i]);
    }
    int z = 0;
    while (hasNegative(banks)) {
      int lowest = 0;
      for (int i = 1; i < n; i++) {
        if (banks[i] < banks[lowest])
          lowest = i;
      }

      int a = banks[lowest] * -1;
      banks[lowest]*= -1;
      banks[(lowest - 1 < 0 ? n - 1 : lowest - 1) % n] -= a;
      banks[(lowest + 1) % n] -= a;
      z++;
    }
    System.out.println(z);
  }
}
