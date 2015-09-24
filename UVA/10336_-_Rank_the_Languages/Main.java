import java.util.*;
import java.io.*;

class Main {
  public static char[][] matrix;
  public static int m;
  public static int n;
  public static Map<Character, Integer> map;
  public static int[] dr = new int[]{-1, 0, 1, 0}; //up, right, down, left
  public static int[] dc = new int[]{0, 1, 0, -1};

  public static int dfs(int row, int col, char c) {
    if (row >= m || row < 0 ||
        col >= n || col < 0 ||
        matrix[row][col] == '~' ||
        matrix[row][col] != c)
      return 0;
    matrix[row][col] = '~';
    int count = 1;
    for (int i = 0; i < 4; i++)
      count += dfs(row + dr[i], col + dc[i], c);
    return count;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      map = new TreeMap<Character, Integer>();
      String[] line = br.readLine().split(" ");
      m = Integer.parseInt(line[0]);
      n = Integer.parseInt(line[1]);
      matrix = new char[m][n];

      for (int row = 0; row < m; row++) {
        char[] c = br.readLine().toCharArray();
        for (int col = 0; col < n; col++) {
          matrix[row][col] = c[col];
        }
      }
      
      for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
          char cell = matrix[row][col];
          if (cell != '~') {
            int count = dfs(row, col, cell);
            if (!map.containsKey(cell))
              map.put(cell, 1);
            else
              map.put(cell, map.get(cell) + 1);
          }
        }
      }
      
      System.out.printf("World #%d\n", i + 1);
      Map<Integer, ArrayList<Character>> sorted = 
        new TreeMap<Integer, ArrayList<Character>>(Collections.reverseOrder());
      for (Character key : map.keySet()) {
        int val = map.get(key);
        ArrayList<Character> lst;
        if (sorted.containsKey(val))
          lst = sorted.get(val);
        else
          lst = new ArrayList<Character>();

        lst.add(key);
        sorted.put(val, lst);
      }

      for (int key : sorted.keySet()) {
        ArrayList<Character> lst = sorted.get(key);
        for (char thing : lst)
          System.out.println(thing + ": " + key);
      }
    
      //for (int l = 0; l < m; l++)
      //  System.out.println(Arrays.toString(matrix[l]));
    }
  }
}
