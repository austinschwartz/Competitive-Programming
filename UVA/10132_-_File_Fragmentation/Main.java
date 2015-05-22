import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N = Integer.parseInt(br.readLine());
    br.readLine();
    for (int i = 0; i < N; i++) {
      line = br.readLine();
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      while (line != null && !line.equals("")) {
        if (line.length() < min) min = line.length();
        if (line.length() > max) max = line.length();
        line = br.readLine();
      }
      System.out.println(min + max);
      if (i < N - 1)
        System.out.println();
    }
  }
}
