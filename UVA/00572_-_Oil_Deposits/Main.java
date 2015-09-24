import java.util.*;
import java.io.*;

class Main {
  public static char[][] matrix;
  public static int m;
  public static int n;
  public static int[] dr = new int[]{-1,-1,0, 1, 1, 1, 0, -1}; //N, NE, E, SE, etc
  public static int[] dc = new int[]{0, 1, 1, 1, 0,-1,-1, -1};
  public static void dfs(int row, int col) {
    if (row < 0 || row >= m ||
        col < 0 || col >= n ||
        matrix[row][col] == '*')
      return;
    matrix[row][col] = '*';
    for (int i = 0; i < 8; i++)
      dfs(row + dr[i], col + dc[i]);
    return;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String[] line = br.readLine().split(" ");
      m = Integer.parseInt(line[0]);
      n = Integer.parseInt(line[1]);
      if (m == 0 || n == 0)
        return;
      matrix = new char[m][n];
      for (int i = 0; i < m; i++) {
        char[] row = br.readLine().toCharArray();
        for (int j = 0; j < n; j++) {
          matrix[i][j] = row[j];
        }
      }
      int count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == '@') {
            count++;
            dfs(i, j);
          }
        }
      }
      System.out.println(count);
    }
  }
}
