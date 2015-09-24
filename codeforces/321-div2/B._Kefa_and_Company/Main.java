import java.util.*;
import java.io.*;

public class Main {
  static int[] matrix, m, s;
  static int n, d;

  public static int max(int a, int b) {
    return a >= b ? a : b;
  }

  public static int maxFriendship(int d, int[] m, int[] s, int n) {
    if (n == 0 || d == 0)
      return 0;

    if (s[n-1] > d)
      return maxFriendship(d, m, s, n-1);
    else
      return max(
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    d = Integer.parseInt(line[1]);
    
    m = new int[n];
    s = new int[n];
    matrix = new int[n];
    for (int i = 0; i < n; i++) {
      line = br.readLine().split(" "); 
      m[i] = Integer.parseInt(line[0]);
      s[i] = Integer.parseInt(line[1]);
    }
    
    System.out.println(maxFriendship(d, m, s, n));
  }
}
