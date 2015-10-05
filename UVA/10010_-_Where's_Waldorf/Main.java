import java.util.*;
import java.io.*;

class Main {
  public static int frow = -1;
  public static int fcol = - 1;
  public static int irow = -1;
  public static int icol = -1;
  public static int rows, cols;
  public static char[][] matrix;
  public static int[] rcoords = {-1, -1, 0, 1, 1, 1, 0, -1};
  public static int[] ccoords = {0, 1, 1, 1, 0, -1, -1, -1};
  public static void findWord(String word, int index, int row, int col, int dir) {
    if (fcol != -1 || frow != -1 ||
        row >= rows || row < 0 ||
        col >= cols || col < 0 ||
        word.charAt(index) != matrix[row][col])
      return;
    if (word.length() - 1 == index) {
      frow = irow;
      fcol = icol;
      return;
    }

    findWord(word, index + 1, row + rcoords[dir], col + ccoords[dir], dir);

    return;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N = Integer.parseInt(br.readLine());
    for (int o = 0; o < N; o++) {
      if (o > 0)
        System.out.println();
      br.readLine();
      String[] s = br.readLine().split(" ");
      rows = Integer.parseInt(s[0]);
      cols = Integer.parseInt(s[1]);
      matrix = new char[rows][cols];

      for (int i = 0; i < rows; i++) {
        char[] row = br.readLine().toLowerCase().toCharArray();
        for (int j = 0; j < cols; j++) {
          matrix[i][j] = row[j];
        }
        //System.out.println(Arrays.toString(row));
      }

      int x = Integer.parseInt(br.readLine());
      String[] words = new String[x];
      for (int i = 0; i < x; i++) {
        words[i] = br.readLine();
        frow = -1;
        fcol = -1;
        irow = -1;
        icol = -1;
        for (int r = 0; r < rows; r++) {
          irow = r + 1;
          for (int c = 0; c < cols; c++) {
            icol = c + 1;
            if (frow == -1 && fcol == -1 &&
                matrix[r][c] == words[i].toLowerCase().charAt(0)) {
              for (int d = 0; d < 8; d++)
                findWord(words[i].toLowerCase(), 0, r, c, d);
            }
          }
        }

        System.out.println(frow + " " + fcol);
      }
    }
  }
}
