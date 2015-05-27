import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] line;
    int N;
    while ((N = Integer.parseInt(br.readLine())) != 0) {
      int spaces = 0;
      int minimum = Integer.MAX_VALUE;
      int[] space = new int[N];
      for (int i = 0; i < N; i++) {
        int count = 0;
        line = br.readLine().toCharArray();
        for (int j = 0; j < line.length; j++)
          if (line[j] == 'B' || line[j] == ' ')
            count++;
        space[i] = count;
        if (count < minimum)
          minimum = count;
      }
      int sum = 0;
      for (int k = 0; k < N; k++)
        sum += (space[k] - minimum);
      System.out.println(sum);
    }
  }
}
