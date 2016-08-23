import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int m = sc.nextInt();

    Map<BigInteger, Integer> set = new LinkedHashMap<BigInteger, Integer>();
    Map<BigInteger, Integer> factors = new LinkedHashMap<BigInteger, Integer>();
    BigInteger x = BigInteger.ONE;
    for (int i = 0; i < m; i++) {
      BigInteger b = BigInteger.valueOf(sc.nextInt());
      if (set.containsKey(b))
        set.put(b, set.get(b) + 1);
      else
        set.put(b, 1);
      x = x.multiply(b);
    }
    System.out.println(set);
    factors.put(x, 1);
    factors.put(BigInteger.ONE, 1);
    BigInteger res = BigInteger.ONE;
    for (BigInteger j : set.keySet()) {
      if (factors.containsKey(j))
        factors.put(j, factors.get(j) + 1);
      else
        factors.put(j, 1);
      for (BigInteger k : set.keySet()) {
        if (j == k) continue;
        BigInteger p = j.multiply(k);
        if ( factors.containsKey(p))
          factors.put(p, factors.get(p) + 1);
        else
          factors.put(p, 1);
      }
    }
    System.out.println(factors);
    for (BigInteger o : factors.keySet()) {
      for (int i = 0; i < factors.get(o); i++)
        res = res.multiply(o);
    }
    System.out.println(res);
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
