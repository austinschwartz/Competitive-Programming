import java.util.*;
import java.io.*;

class Main {
  public enum Direction {NORTH, EAST, SOUTH, WEST};
  public static class Grid {
    public Direction dir;
    public int row, col, N, M;
    public int stickers;
    public char[][] grid;
    public Grid(char[][] grid, int N, int M, int startRow, int startCol) {
      this.grid = grid;
      this.N = N;
      this.M = M;
      this.row = startRow;
      this.col = startCol;
      this.stickers = 0;
      char start = grid[startRow][startCol];
      grid[startRow][startCol] = '.';
      switch (start) {
        default:
        case 'N':
          this.dir = Direction.NORTH;
          break;
        case 'S':
          this.dir = Direction.SOUTH;
          break;
        case 'L':
          this.dir = Direction.EAST;
          break;
        case 'O':
          this.dir = Direction.WEST;
          break;
      }
    }
    public void rotateCW() {
      switch (this.dir) {
        case NORTH:
          this.dir = Direction.EAST;
          break;
        case EAST:
          this.dir = Direction.SOUTH;
          break;
        case SOUTH:
          this.dir = Direction.WEST;
          break;
        case WEST:
          this.dir = Direction.NORTH;
          break;
      }
    }
    public void rotateCCW() {
      switch (this.dir) {
        case NORTH:
          this.dir = Direction.WEST;
          break;
        case EAST:
          this.dir = Direction.NORTH;
          break;
        case SOUTH:
          this.dir = Direction.EAST;
          break;
        case WEST:
          this.dir = Direction.SOUTH;
          break;
      }
    }
    public void moveForward() {
      int currentRow = this.row;
      int currentCol = this.col;
      Direction d = this.dir;
      switch (d) {
        case NORTH:
          currentRow -= 1;
          break;
        case EAST:
          currentCol += 1;
          break;
        case SOUTH:
          currentRow += 1;
          break;
        case WEST:
          currentCol -= 1;
          break;
      }
      if (currentRow >= 0 && currentRow < N &&
          currentCol >= 0 && currentCol < M &&
          grid[currentRow][currentCol] != '#') {
        this.row = currentRow;
        this.col = currentCol;
        if (grid[row][col] == '*') {
          this.stickers++;
          grid[row][col] = '.';
        }
      }
    }
    public void action(char a) {
      switch (a) {
        case 'D':
          rotateCW();
          break;
        case 'E':
          rotateCCW();
          break;
        case 'F':
          moveForward();
          break;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null && !line.equals("0 0 0")) {
      String[] s = line.split(" ");
      int N = Integer.parseInt(s[0]);
      int M = Integer.parseInt(s[1]);
      int S = Integer.parseInt(s[2]);
      char[][] grid = new char[N][M];
      int startRow = -1, startCol = -1;
      for (int i = 0; i < N; i++) {
        char[] row = br.readLine().toCharArray();
        for (int j = 0; j < M; j++) {
          grid[i][j] = row[j];
          if (Arrays.asList('N', 'S', 'L', 'O').contains(row[j])) {
            startRow = i;
            startCol = j;
          }
        }
      }
      Grid g = new Grid(grid, N, M, startRow, startCol);
      char[] instructions = br.readLine().toCharArray();
      for (char a : instructions) {
        g.action(a);
      }
      System.out.println(g.stickers);
    }
  }
}
