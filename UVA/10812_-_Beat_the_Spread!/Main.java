import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      int s = Integer.parseInt(line[0]);
      int d = Integer.parseInt(line[1]);

      int y = Math.abs(s - d) / 2;
      int x = s - y;
      if (Math.abs(x - y) == d && x + y == s)
        System.out.println(x + " " + y);
      else
        System.out.println("impossible");

    }
  }
}
