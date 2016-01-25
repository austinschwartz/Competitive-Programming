import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static boolean[][] grid;
  public static int x, y, X, Y;
  public static char c;
  public static boolean dfs(int _x, int _y, char _c, char[] str, int i) {

    if (_x > X || _y > Y || _x < 0 || _y < 0) {
      return false;
    }

    if (!grid[_x][_y]) return false;

    if (i >= str.length) {
      x = _x;
      y = _y;
      c = _c;
      return true;
    }

    char dirToMove = str[i];
    if (dirToMove == 'F') {
      int newX = _x, newY = _y;
      if (_c == 'N') newY++; 
      if (_c == 'E') newX++; 
      if (_c == 'S') newY--; 
      if (_c == 'W') newX--;
      if (dfs(newX, newY, _c, str, i+1))
        return true;
      else e
        grid[_x][_y] = true;
        return false;
      }
    }

    boolean res = false;
    switch (c) {
      case 'N':
        if (dirToMove == 'L') res = dfs(_x, _y, 'W', str, i + 1);
        if (dirToMove == 'R') res = dfs(_x, _y, 'E', str, i + 1);
        break;
      case 'E':
        if (dirToMove == 'L') res = dfs(_x, _y, 'N', str, i + 1);
        if (dirToMove == 'R') res = dfs(_x, _y, 'S', str, i + 1);
        break;
      case 'S':
        if (dirToMove == 'L') res = dfs(_x, _y, 'E', str, i + 1);
        if (dirToMove == 'R') res = dfs(_x, _y, 'W', str, i + 1);
        break;
      case 'W':
        if (dirToMove == 'L') res = dfs(_x, _y, 'S', str, i + 1);
        if (dirToMove == 'R') res = dfs(_x, _y, 'N', str, i + 1);
        break;
    }

    return res;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    X = sc.nextInt();
    Y = sc.nextInt();
    grid = new boolean[X + 1][Y + 1];
    while (sc.hasNext()) {
      x = sc.nextInt();
      y = sc.nextInt();
      c = sc.nextChar();
      char[] str = sc.next().toCharArray();

      if (dfs(x, y, c, str, 0))
        System.out.println(x + " " + y + " " + c);
      else
        System.out.println(x + " " + y + " " + c + " LOST");
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
