import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] squares = new int[n];
    int[] cum = new int[n + 1];
    cum[0] = 0;
    for (int squares_i = 0; squares_i < n; squares_i++) {
      squares[squares_i] = in.nextInt();
      cum[squares_i + 1] = cum[squares_i] + squares[squares_i];
    }
    int d = in.nextInt();
    int m = in.nextInt();
    int ways = 0;
    n += 1;
    for (int i = 0; i < n && i + m >= 0 && i + m < n; i++) {
      if (cum[i + m] - cum[i] == d) {
        ways += 1;
      }
    }
    System.out.println(ways);
  }
}

