import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {
  static int it = 0;
  public static long reverse(long a) {
    long rev = 0;
    while (a != 0) {
     rev = rev * 10 + a % 10;
     a /= 10;
    }
    return rev;
  }

  public static boolean isPalindrome(long a) {
    return reverse(a) == a;
  }
  
  public static long reverseAndAdd(long a) {
    long rev = reverse(a);
    a += rev;
    if (!isPalindrome(a)) {
      it += 1;
      return reverseAndAdd(a);
    }
    else
      return a;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long x;
    for (int i = 0; i < N; i++) {
      x = Long.parseLong(br.readLine());
      it = 1;
      long r = reverseAndAdd(x);
      System.out.println(it + " "  + r);
    }
  }
}
