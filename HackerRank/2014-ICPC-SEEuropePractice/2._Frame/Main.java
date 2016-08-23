import java.util.*;
import java.io.*;

class Main {
  public static boolean possible(int x, int y, int a) {
    int perimeter = x + x + y + y - 4;
    if (a > x || a > y) 
      return false;
    if (perimeter % a != 0)
      return false;
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int x = Integer.parseInt(s[0]);
    int y = Integer.parseInt(s[1]);
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(br.readLine());
      System.out.println(possible(x, y, a) ? "YES" : "NO");
    }
  }
}
