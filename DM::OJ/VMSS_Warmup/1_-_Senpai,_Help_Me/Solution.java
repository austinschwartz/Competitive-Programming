import java.io.*;
import java.math.*;

public class Solution {
  public static int per(int a) {
    int min = Integer.MAX_VALUE;
    int i = 1;
    while (i <= a) {
      if (a % i == 0) {
        int x = a / i;
        int perimeter = x + x + i + i;
        if (perimeter < min)
          min = perimeter;
      }
      i++;
    }
    return min;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    System.out.println(per(a));
  }
}
