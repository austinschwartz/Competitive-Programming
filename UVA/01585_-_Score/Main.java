import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[] arr;
    for (int i = 0; i < N; i++) {
      arr = br.readLine().toCharArray();
      int[] m = new int[arr.length];
      int score = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == 'O') {
          if (j > 0)
            m[j] = m[j-1] + 1;
          else
            m[j] = 1;
        } else {
          m[j] = 0;
        }
        score += m[j];
      }
      System.out.println(score);
    }
  }
}
