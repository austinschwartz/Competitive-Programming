import java.util.*;
import java.io.*;

class Main {
  public static class Cell {
    public int weight;
    public int prev;
  }
  public static int m, n;
  public static int[][] matrix;
  public static Cell[][] paths;
  public static int paths(int row, int col) {
    if (row == -1) row = m - 1;
    else if (row == m) row = 0;
    if (row < 0 || row >= m ||
        col < 0 || col >= n)
      return -1;
    if (paths[row][col] != 0)
      return paths[row][col];
    int nw = paths(row-1, col-1);
    int w = paths(row, col-1);
    int sw = paths(row+1, col-1);
    if (nw <= w && nw <= sw) {
      paths[row][col] = nw + matrix[row][col];
      parents[row][col] = (row-1 == -1 ? m-1 : (row-1 == m ? 0 : row-1));
    } else if (w <= nw && w <= sw) {
      paths[row][col] = w + matrix[row][col];
      parents[row][col] = row;
    } else {
      paths[row][col] = sw + matrix[row][col];
      parents[row][col] = (row+1 == -1 ? m+1 : (row+1 == m ? 0 : row+1));
    }
    return paths[row][col];
  }
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      m = sc.nextInt();
      n = sc.nextInt();
      matrix = new int[m][n];
      paths = new int[m][n];
      parents = new int[m][n];

      // Get input
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = sc.nextInt();
          paths[i][j] = new Cell();
        }
      }

      // Calculate DP table
      for (int row = 0; row < m; row++) {
        paths[row][0].weight = matrix[row][0];
        paths[row][0].prev = -1;
      }

      for (int row = 0; row < m; row++)
        for (int col = 1; col < n; col++)
          paths(row, col);
      
      // Calculate min
      int min = Integer.MAX_VALUE;
      int min_row = -1;
      for (int row = 0; row < m; row++) {
        if (paths[row][n-1] < min) {
          min = paths[row][n-1];
          min_row = row;
        }
      }
      for (int row = 0; row < m; row++)
        System.out.println(Arrays.toString(path[row]));
      System.out.println(min);
    }
  }
}
