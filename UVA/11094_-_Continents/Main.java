import java.util.*;
import java.io.*;

class Main {
  public static int[][] matrix;
  public static int M;
  public static int N;
  //public static int[] dr = new int[] {-1, -1, 0, 1, 1, 1, 0, 1};
  //public static int[] dc = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
  public static int[] dr = new int[] {-1, 0, 1, 0};
  public static int[] dc = new int[] {0, 1, 0, -1};
  public static int islands;
  public static int currentIsland;
  public static int biggestIsland;

  public static void printMatrix() {
    for (int i = 0; i < M; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  public static void dfs(int row, int col) {
    if (col == -1)  col = N - 1;
    if (col == N)   col = 0;
    if (row >= M || row < 0 || 
        col >= N || col < 0 ||
        matrix[row][col] == 0)
      return;
    if (islands > -1)
      currentIsland = currentIsland + 1;
    matrix[row][col] = 0;
    for (int i = 0; i < 4; i++)
      dfs(row + dr[i], col + dc[i]);
    return;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp;
    while ((temp = br.readLine()) != null) {
      currentIsland = 0;
      biggestIsland = 0;
      islands = -1;
      String[] line = temp.split(" ");
      M = Integer.parseInt(line[0]);
      N = Integer.parseInt(line[1]);
      matrix = new int[M][N];
      char[][] charmatrix = new char[M][N];
      for (int i = 0; i < M; i++) { 
        char[] row = br.readLine().toCharArray();
        for (int j = 0; j < N; j++) {
          charmatrix[i][j] = row[j];
        }
      }
      line = br.readLine().split(" ");
      int x = Integer.parseInt(line[0]);
      int y = Integer.parseInt(line[1]);
      if (x >= M || y >= N || x < 0 || y < 0) {
        System.out.println(0);
        br.readLine();
        continue;
      }
      char landChar = charmatrix[x][y];
      //System.out.println(landChar);

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) { 
          char cell = charmatrix[i][j];
          matrix[i][j] = (cell == landChar ? 1 : 0);
        }
      }

      // Need to remove the kings island from consideration
      dfs(x, y);

      // Now find biggest connected component
      islands = 0;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (matrix[i][j] == 1) {
            currentIsland = 0;
            dfs(i, j);
            if (currentIsland > biggestIsland)
              biggestIsland = currentIsland;
            islands++;
          }
        }
      }

      System.out.println(biggestIsland);  
      br.readLine(); 
    }
  }
}
