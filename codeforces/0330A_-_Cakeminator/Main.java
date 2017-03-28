import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int r = sc.nextInt();
    int c = sc.nextInt();
    int[][] cake = new int[r][c];
    for (int i = 0; i < r; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < line.length(); j++)
        if (line.charAt(j) == 'S')
          cake[i][j] = 5;
    }

    int ret = 0;
    for (int i = 0 ; i < r; i++) {
      int clear = 0;
      for (int j = 0; j < c; j++) {
        if (cake[i][j] != 5)
          clear += 1;
      }
      if (clear == c) {
        for (int j = 0; j < c; j++) {
          if (cake[i][j] == 0) {
            cake[i][j] = 1;
            ret += 1;
          }
        }
      }
    }

    for (int j = 0 ; j < c; j++) {
      int clear = 0;
      for (int i = 0; i < r; i++) {
        if (cake[i][j] != 5)
          clear += 1;
      }
      if (clear == r) {
        for (int i = 0; i < r; i++) {
          if (cake[i][j] == 0) {
            cake[i][j] = 1;
            ret += 1;
          }
        }
      }
    }

    out.println(ret);
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
