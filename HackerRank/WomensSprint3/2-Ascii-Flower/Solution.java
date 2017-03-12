import java.io.*;
import java.util.*;

public class Solution {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int r = sc.nextInt();
    int c = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < r; i++) {
      sb = new StringBuilder();
      for (int j = 0; j < c; j++) {
        sb.append("..O..");
      }
      sb.append("\n");
      for (int j = 0; j < c; j++) {
        sb.append("O.o.O");
      }
      sb.append("\n");
      for (int j = 0; j < c; j++) {
        sb.append("..O..");
      }
      out.println(sb.toString());
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
