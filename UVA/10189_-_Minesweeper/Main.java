import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = 1;
    String line;
    while (!(line = br.readLine()).equals("0 0")) {
      if (c > 1)
        System.out.println();
      System.out.println("Field #" + c + ":");
      StringTokenizer stk = new StringTokenizer(line);
      int n = Integer.parseInt(stk.nextToken());
      int m = Integer.parseInt(stk.nextToken());
      char[][] board = new char[n][m];
      int[][] board2 = new int[n][m];
      for (int i = 0; i < n; i++) {
        board[i] = br.readLine().toCharArray();
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (board[i][j] == '*') {
            if (j+1 < m)  board2[i][j+1]++;
            if (j-1 >= 0) board2[i][j-1]++;
            if (i+1 < n)  board2[i+1][j]++;
            if (i-1 >= 0) board2[i-1][j]++;
            if (i-1 >= 0 && j-1 >= 0) board2[i-1][j-1]++;
            if (i-1 >= 0 && j+1 < m)  board2[i-1][j+1]++;
            if (i+1 < n && j-1 >= 0)  board2[i+1][j-1]++;
            if (i+1 < n && j+1 < m)   board2[i+1][j+1]++;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (board[i][j] == '.')
            System.out.print(board2[i][j]);
          else
            System.out.print('*');
        }
        System.out.println();
      }
      c++;
    }
  }
}
