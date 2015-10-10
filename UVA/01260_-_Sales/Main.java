import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int x = 0; x < T; x++) {
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      String s[] = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(s[i]);
      }
      int bs = 0;
      for (int i = 1; i < n; i++) {
        int bi = 0;
        for (int k = 0; k < i; k++) {
          if (a[k] <= a[i])
            bi += 1;
        }
        bs += bi;
      }
      System.out.println(bs);
    }
  }
}
