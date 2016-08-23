import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String line = sc.next();
    int x = line.charAt(0) - 'a';
    int y = line.charAt(1) - '1';
    int ans = 0;
    for (int[] coord : coords) {
      if (isValid(x + coord[0], y + coord[1]))
        ans++;
    }
    out.println(ans);

    out.close();
  }

  public static boolean isValid(int x, int y) {
    if (x < 0 || y < 0 || x > 7 || y > 7) 
      return false;
    return true;
  }

  public static int[][] coords = new int[][]{
    {-1, -1}, {-1, 0}, {-1, 1}, 
    {0, -1}, {0, 1},
    {1, -1}, {1, 0}, {1, 1}
  };


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
