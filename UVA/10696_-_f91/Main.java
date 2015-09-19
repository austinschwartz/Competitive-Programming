import java.util.*;
import java.io.*;

class Main {
  public static int[] table = new int[2 << 19];
  public static int f91(int N) {
    if (table[N] != -1)
      return table[N];
    else {
      if (N <= 100)
        table[N] = f91(f91(N + 11));
      else {
        table[N] = N - 10;
      }
      return table[N];
    }
  }
  public static void main(String[] args) throws Exception {
    Arrays.fill(table, -1);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    while ((N = Integer.parseInt(br.readLine())) != 0) {
      System.out.printf("f91(%d) = %d\n", N, f91(N));
    }
  }
}
