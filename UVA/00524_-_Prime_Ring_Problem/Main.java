import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static Set<Integer> primes = new HashSet<Integer>(){{
    add(2);
    add(3);
    add(5);
    add(7);
    add(11);
    add(13);
    add(17);
    add(19);
    add(23);
    add(29);
    add(31);
    add(37);
  }};
  public static boolean isPrime(int num) {
    return primes.contains(num);
  } 
  public static int[] circle = new int[20];
  public static boolean[] used = new boolean[20];
  public static int n;

  public static void search(int m) {
    if (m == n - 1 && isPrime(circle[n - 1] + 1)) {
      for (int i = 0; i < n; i++) {
        out.print(circle[i]);
        if (i < n - 1)
          out.print(" ");
      }
      out.println();
    }
    for (int i = 2; i <= n; i++) {
      if (!used[i] && isPrime(circle[m] + i)) {
        used[i] = true;
        circle[m + 1] = i;
        search(m + 1);
        used[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int i = 1;
    while (sc.hasNext()) {
      n = sc.nextInt();
      if (i > 1)
        out.println();
      circle[0] = circle[n] = 1;
      out.println("Case " + i + ":");
      search(0);
      i++;
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
