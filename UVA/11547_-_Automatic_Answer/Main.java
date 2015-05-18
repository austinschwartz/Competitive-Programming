import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int t = Integer.parseInt(line);
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      n *= 567;
      n /= 9;
      n += 7492;
      n *= 235;
      n /= 47;
      n -= 498;
      System.out.println(Math.abs( (n % 100) / 10 ));
    }
  }
}
