import java.util.*;
import java.io.*;

class Main {
  public static char[][] matrix;
  public static int N;
  public static int[][] move = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  public static void mark(int i, int j) {
    matrix[i][j] = '0';
    for (int k = 0; k < 4; k++) {
      int row = i + move[k][0];
      int col = j + move[k][1];
      if (row >= 0 && row < N &&
          col >= 0 && col < N &&
          (matrix[row][col] == 'x' || matrix[row][col] == '@'))
        mark(row, col);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());
      matrix = new char[N][N];
      for (int j = 0; j < N; j++) {
        String line = br.readLine();
        char[] chars = line.toCharArray();
        for (int k = 0; k < chars.length; k++) {
          matrix[j][k] = chars[k];
        }
      }

      int components = 0;
      for (int m = 0; m < N; m++) {
        for (int n = 0; n < N; n++) {
          if (matrix[m][n] == 'x') {
            mark(m, n);
            components++;
          }     
        }
      }
      System.out.printf("Case %d: %d\n", (i+1), components);
    }
  }
}
