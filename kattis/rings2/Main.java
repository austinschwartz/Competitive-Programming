import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[][] deltas = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] grid = new int[n][m];
    for (int i = 0; i < n; i++)
      Arrays.fill(grid[i], -1);

    Queue<int[]> queue = new LinkedList<int[]>();

    for (int i = 0; i < n; i++) {
      char[] line = sc.nextLine().toCharArray();
      for (int j = 0; j < m; j++) {
        if (line[j] == '.') {
          queue.add(new int[]{i, j, 0});
        }
      }
    }

    // Add top and bottom borders
    for (int i = 0; i < n; i++) {
      queue.add(new int[]{i, -1, 0});
      queue.add(new int[]{i, n, 0});
    }

    // Add left and right sides
    for (int j = 0; j < m; j++) {
      queue.add(new int[]{-1, j, 0});
      queue.add(new int[]{m, j, 0});
    }

    while (!queue.isEmpty()) {
      int[] temp = queue.remove();
      int r = temp[0];
      int c = temp[1];
      int val = temp[2];
      if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == -1)
        grid[r][c] = val;
      for (int i = 0; i < 4; i++) {
        int nr = r + deltas[i][0];
        int nc = c + deltas[i][1];
        if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == -1) {
          queue.add(new int[]{nr, nc, val + 1});
        }
      }
    }

    boolean threeChars = false;
    for (int i = 0; i < n && threeChars == false; i++)
      for (int j = 0; j < m && threeChars == false; j++)
        if (grid[i][j] >= 10)
          threeChars = true;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0)
          out.print(threeChars ? "..." : "..");
        else
          out.print(String.format(threeChars ? "%3d" : "%2d", grid[i][j]).replaceAll(" ", "."));
      }
      out.println();
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
