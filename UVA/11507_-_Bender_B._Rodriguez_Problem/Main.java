import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    long L;
    while ((L = sc.nextLong()) != 0) {
      String cur = "+x";
      String[] stk = sc.nextLine().split(" ");
      for (String tok : stk) {
        if (!tok.equals("No"))
          cur = bend(cur, tok);
      }
      out.println(cur);
    }
    out.close();
  }

  public static String bend(String cur, String tok) {
    if (cur.equals("+x")) {
        if (tok.equals("+y")) return "+y";
        if (tok.equals("-y")) return "-y";
        if (tok.equals("+z")) return "+z";
        if (tok.equals("-z")) return "-z";
    } else if (cur.equals("-x")) {
        if (tok.equals("+y")) return "-y";
        if (tok.equals("-y")) return "+y";
        if (tok.equals("+z")) return "-z";
        if (tok.equals("-z")) return "+z";
    } else if (cur.equals("+y")) {
        if (tok.equals("+y")) return "-x";
        if (tok.equals("-y")) return "+x";
        if (tok.equals("+z")) return "+y";
        if (tok.equals("-z")) return "+y";
    } else if (cur.equals("-y")) {
        if (tok.equals("+y")) return "+x";
        if (tok.equals("-y")) return "-x";
        if (tok.equals("+z")) return "-y";
        if (tok.equals("-z")) return "-y";
    } else if (cur.equals("+z")) {
        if (tok.equals("+y")) return "+z";
        if (tok.equals("-y")) return "+z";
        if (tok.equals("+z")) return "-x";
        if (tok.equals("-z")) return "+x";
    } else if (cur.equals("-z")) {
        if (tok.equals("+y")) return "-z";
        if (tok.equals("-y")) return "-z";
        if (tok.equals("+z")) return "+x";
        if (tok.equals("-z")) return "-x";
    }
    return cur;
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
