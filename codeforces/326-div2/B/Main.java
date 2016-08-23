import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long[] primes = new long[100];
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    long n = sc.nextLong();
  
    int k = 0;
    for (long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        primes[k++] = i;
        while (n % i == 0) {
          n /= i;
        }
      }
    }
    if (n > 1) primes[k++] = n;

    int ans = 1;
    for (int i = 0; i < k; i++) {
      if (primes[i] != 0) {
        ans *= primes[i];
      }
    }
    out.println(ans);

    out.close();
  }



  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;
      } catch (IOException e) {
        return false;
      }
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char nextChar() {
      return next().charAt(0);
    }

    public String nextLine() {
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
