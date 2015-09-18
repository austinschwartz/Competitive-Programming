import java.util.*;
import java.io.*;

public class Solution {
  static char[][] grid;
  static int total = 0;
  static int r;
  static int c;

  public static void dfs(int row, int col) {
    if (row >= r || col >= c || row < 0 || col < 0 || grid[row][col] != '.')
      return;
    else {
      grid[row][col] = '-';
      dfs(row, col + 1);
      dfs(row + 1, col);
      dfs(row, col - 1);
      dfs(row - 1, col);
    }
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    r = Integer.parseInt(line[0]);
    c = Integer.parseInt(line[1]);
    grid = new char[r][c];
    char[] gridLine;
    for (int i = 0; i < r; i++) {
      gridLine = br.readLine().toCharArray();
      for (int j = 0; j < c; j++) {
        grid[i][j] = gridLine[j];
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == '.') {
          total++;
          dfs(i, j);
        }
      }
    }

    System.out.println(total);
  }
}
