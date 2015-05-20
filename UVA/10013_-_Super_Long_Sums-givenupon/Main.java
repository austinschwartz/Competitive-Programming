import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      br.readLine();
      int M = Integer.parseInt(br.readLine());
      String x = new String();
      String y = new String();
      for (int j = 0; j < M; j++) {
        String[] arr = br.readLine().split(" ");
        long a = Long.parseLong(arr[0]);
        long b = Long.parseLong(arr[1]);

        x += "" + a;
        y += "" + b;
      }
      BigInteger xx = new BigInteger(x);
      BigInteger yy = new BigInteger(y);
      System.out.println(xx.add(yy));
      if (i < N - 1)
        System.out.println();
    }
  }
}
