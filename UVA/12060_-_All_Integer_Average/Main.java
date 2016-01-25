import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = -1;
    int k = 1;
    while ((n = sc.nextInt()) != 0) {
      int total = 0;
      for (int i = 0; i < n; i++) {
        int num = sc.nextInt();
        total += num;
      }
      double avgDouble = total / (double)n;
      System.out.println("Case " + k++ + ":");
      if ((int)Math.floor(avgDouble) == (int)Math.ceil(avgDouble)) {
        int avg = (int)Math.floor(avgDouble);
        if (avg < 0) {
          System.out.print("- ");
          avg = Math.abs(avg);
        }
        System.out.println(avg);
      } else {
        int num = total / n;
        int g = gcd(total, n);
        int denom = Math.abs(n / g);
        int numer = Math.abs(total % n / g);
        String dString = String.valueOf(Math.abs(denom));
        String nString = String.valueOf(Math.abs(numer));
        String numString = String.valueOf(Math.abs(num));
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();

        if (total < 0) {
          line1.append("  ");
          line2.append("- ");
          line3.append("  ");
        }

        if (num != 0) {
          for (int i = 0; i < numString.length(); i++) {
            line1.append(" ");
            line3.append(" ");
          }
        }

        if (num != 0)
          line2.append(Math.abs(num));

        for (int i = 0; i < dString.length(); i++)
          line2.append("-");

        for (int i = 0; i < dString.length() - nString.length(); i++)
          line1.append(" ");

        line1.append(nString);
        line3.append(dString);

        System.out.println(line1.toString()); 
        System.out.println(line2.toString()); 
        System.out.println(line3.toString()); 
      }
    }
    out.close();
  }

  public static int gcd(int a, int b) {
    if (a == 0) return b;
    return gcd(b % a, a);
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
