import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      StringTokenizer stk = new StringTokenizer(line);
      int a = Integer.parseInt(stk.nextToken());
      int b = Integer.parseInt(stk.nextToken());
      System.out.println(a ^ b);
    }
  }
}
