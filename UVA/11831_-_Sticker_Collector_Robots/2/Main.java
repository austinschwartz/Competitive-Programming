import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int N, M, S;
  public static char[][] grid;
  public static int stickers = 0;
  public static int[] loc = new int[]{0, 0};
  public static char dir = 'N';
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    
    while (((N = sc.nextInt()) > -1) &&
           ((M = sc.nextInt()) > -1) &&
           ((S = sc.nextInt()) > -1) && 
          !(N == 0 && M == 0 && S == 0)) {
      stickers = 0;
      loc = new int[]{0, 0};
      grid = new char[N][M];
      for (int i = 0; i < N; i++) {
        char[] line = sc.nextLine().toCharArray();
        for (int j = 0; j < M; j++) {
          char f = line[j];
          grid[i][j] = f;
          if (f == 'N' || f == 'S' || f == 'L' || f == 'O') {
            loc = new int[]{i, j};
            dir = f;
            grid[i][j] = '.';
          }
        }
      }

      char[] instructions = sc.nextLine().toCharArray();

      for (char c : instructions)
        go(c);

      out.println(stickers);

    }
    out.close();
  }
  
  // North = N, South = S, East = L, West = O
  public static void go(char c) {
    int i = loc[0]; int j = loc[1];
    if (c == 'D') {
           if (dir == 'N') dir = 'L';
      else if (dir == 'L') dir = 'S';
      else if (dir == 'S') dir = 'O';
      else if (dir == 'O') dir = 'N';
    } else if (c == 'E') {
           if (dir == 'N') dir = 'O';
      else if (dir == 'L') dir = 'N';
      else if (dir == 'S') dir = 'L';
      else if (dir == 'O') dir = 'S';
    } else if (c == 'F') {
      if (dir == 'N') {i--;}
      if (dir == 'L') {j++;}
      if (dir == 'S') {i++;}
      if (dir == 'O') {j--;}
      if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == '#')
        return;
      loc = new int[]{i, j};
      if (grid[i][j] == '*') {
        stickers++;
        grid[i][j] = '.';
      }
    }
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
