import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int MAX = 10001;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    boolean[] isPrime = new boolean[MAX];
    int[] primes = new int[1301];
    int p = 0;
    Arrays.fill(isPrime, true);
    isPrime[1] = false;
    for (int i = 2; i < MAX; i++) {
      if (isPrime[i]) {
        primes[p] = i;
        p += 1;
        for (int j = i*i; j < MAX; j += i) {
          isPrime[j] = false;
        }
      }
    }

    int[] ans = new int[MAX];
    for (int i = 0; i < p; i++) {
      int tmp = 0;
      for (int j = i; j < p; j++) {
        tmp += primes[j];
        if (tmp > MAX)
          break;
        ans[tmp] += 1;
      }
    }

    while (sc.hasNext()) {
      int n = sc.nextInt();
      if (n == 0)
        break;
      out.println(ans[n]);
    }

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
