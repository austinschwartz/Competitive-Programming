import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;
    while ((n = Integer.parseInt(br.readLine())) != -1) {
      boolean[] prime = new boolean[n + 1];
      Arrays.fill(prime, true);
      prime[0] = false;
      prime[1] = false;
      for (int i = 2; i <= Math.sqrt(n); i++)
        if (prime[i])
          for (int k = i*i; k <= n; k+=i)
            prime[k] = false;
      System.out.println(Arrays.toString(prime));
    }
  }
}
