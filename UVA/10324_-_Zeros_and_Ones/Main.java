import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int c = 1;
    while ((line = br.readLine()) != null) {
      System.out.println("Case " + c + ":");
      int N = Integer.parseInt(br.readLine());
      for (int k = 0; k < N; k++) {
        boolean found = true;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(stk.nextToken());
        int j = Integer.parseInt(stk.nextToken());
        if (i > j) {
          int tmp = j;
          j = i;
          i = tmp;
        }
        for (int l = i; l < j; l++) {
          if (line.charAt(l) != line.charAt(l + 1)) {
            found = false;
            break;
          }
        }
        System.out.println(found ? "Yes" : "No");
      }
      c++;
    }
  }
}
