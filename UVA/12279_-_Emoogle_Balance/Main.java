import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int casenum = 1;
    while (!(line = br.readLine().trim()).equals("0")) {
      int N = Integer.parseInt(line);
      line = br.readLine();
      String[] arr = line.split(" ");
      int balance = 0;
      for (int i = 0; i < N; i++) {
        int x = Integer.parseInt(arr[i]);
        if (x >= 1 && x <= 99)
          balance += 1;
        if (x == 0)
          balance -= 1;
      }
      System.out.println("Case " + casenum + ": " + balance);
      casenum++;
    }
  }
}
