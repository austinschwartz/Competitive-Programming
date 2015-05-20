import java.util.*;
import java.io.*;

class Main {
  public static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                                73, 79, 83, 89, 97};

  public static boolean isPrime(int a) {
    for (int i = 0; i < primes.length; i++) {
      if (a == primes[i])
        return true;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    while ((N = Integer.parseInt(br.readLine())) != 0) {
      int[] primes = new int[100];
      for (int i = 1; i <= N; i++) {
        for (int j = i - 1; j >= 1; j--) {
          if (i % j == 0) {
            if (isPrime(j))
              primes[j]++;
            if (isPrime(i / j))
              primes[(i / j)]++;
          }
        }
      }
      System.out.print(N + "\n\t" + N + "! = ");
      for (int k = 0; k < primes.length; k++) {
        if (primes[k] > 0)
          System.out.print(primes[k] + "  ");
      }
      System.out.println();
    }
  }
}
