import java.util.*;
import java.io.*;

class Main {
  public static int m, n;
  public static int[][] matrix;
  public static int[][] paths;
  public static int[][] parents;
  public static int p(int row, int col) {
    if (row == -1) 
      row = m - 1;
    else if (row == m) 
      row = 0;

    if (row < 0 || row >= m ||
        col < 0 || col >= n)
      return 999999;

    if (paths[row][col] != 999999)
      return paths[row][col];

    int nw = p(row - 1, col - 1);
    int w  = p(row,     col - 1);
    int sw = p(row + 1, col - 1);

    if (nw <= w && nw <= sw) {
      paths[row][col] = nw + matrix[row][col];
      parents[row][col] = (row-1 == -1 ? m-1 : (row-1 == m ? 0 : row-1));
    } else if (w <= nw && w <= sw) {
      paths[row][col]   = w + matrix[row][col];
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
      matrix  = new int[m][n];
      paths   = new int[m][n];
      parents = new int[m][n];

      for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
          matrix[i][j] = sc.nextInt();

      for (int i = 0; i < m; i++)
        Arrays.fill(paths[i], 999999);

      for (int i = 0; i < m; i++)
        paths[i][0] = matrix[i][0];

      for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
          p(i, j);
      
      int min = Integer.MAX_VALUE;
      int min_row = -1;

      for (int i = 0; i < m; i++) {
        if (paths[i][n-1] < min) {
          min = paths[i][n-1];
          min_row = i;
        }
      }

      for (int i = 0; i < m; i++) {
        if (paths[i][n-1] == min && i <= min_row) {
          min_row = i;
        }
      }

      int i = n - 1;
      List<Integer> ret = new ArrayList<Integer>();
      ret.add(min_row + 1);
      while (i > 0) {
        ret.add(parents[min_row][i] + 1);
        min_row = parents[min_row][i];
        i--;
      }
      Collections.reverse(ret);
      System.out.println(ret);
      System.out.println(min);
    }
  }
}
