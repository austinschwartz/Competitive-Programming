import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {
  public static long g(long n) {
    if (n / 10 == 0)
      return n;
    else {
      int digits = (int)(Math.log10(n)+1);
      int num = 0;
      for (int i = 0; i < digits; i++) {
         num += (n % 10);
         n /= 10;
      }
      return g(num);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n;
    while ((n = Long.parseLong(br.readLine())) != 0L) {
      System.out.println(g(n));
    }
  }
}
