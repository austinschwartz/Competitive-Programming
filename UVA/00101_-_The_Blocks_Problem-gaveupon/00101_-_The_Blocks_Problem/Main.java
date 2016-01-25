import java.util.*;
import java.io.*;

class Main {
  public static int N;
  public static int[][] blocks;
  public static int[] indices;

  public static void printBlocks() {
    for (int i = 0; i < N; i++) {
      System.out.print(i + ": ");
      for (int j = 0; j < indices[i]; j++)
        System.out.print(blocks[i][j] + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    blocks = new int[N][N];
    indices = new int[N];
    for (int i = 0; i < N; i++) {
      blocks[i][0] = i;
      indices[i] = 1;
    }
    String[] line;
    while (true) {
      line = br.readLine().split(" ");
      if (line[0].equals("quit")) {
        printBlocks();
        return;
      }
      int firstNum = Integer.parseInt(line[1]);
      int secondNum = Integer.parseInt(line[3]);
      if (line[0].equals("move")) {
        
      }
    }
  }
}
