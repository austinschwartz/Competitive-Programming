import java.util.*;
import java.io.*;

class Main {
  public static int[][] matrix;
  public static int size;
  public static int[] visited;
  public static int components = 0;
  public static void dfs(int node) {
    visited[node] = 1;
    for (int i = 0; i < size; i++) {
      if (matrix[node][i] == 1 && visited[i] == 0) {
        dfs(i);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String line = br.readLine();
    for (int i = 0; i < T; i++) {
      String largest = br.readLine();
      size = largest.toLowerCase().charAt(0) - 'a' + 1;
      matrix = new int[size][size];
      visited = new int[size];
      while ((line = br.readLine()) != null && !line.equals("")) {
        char[] arr = line.toLowerCase().toCharArray();
        int left = arr[0] - 'a' + 1;
        int right = arr[1] - 'a' + 1;
        matrix[left-1][right-1] = 1;
        matrix[right-1][left-1] = 1;
      }
      /*
      for (int j = 0; j < size; j++) {
        System.out.println(Arrays.toString(matrix[j]));
      }
      */
      components = 0;
      for (int j = 0; j < size; j++) {
        if (visited[j] == 0) {
          dfs(j);
          components++;
        }
      }
      System.out.println(components);
      if (i < T - 1)
        System.out.println();
    }
  }
}
