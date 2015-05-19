import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int T = Integer.parseInt(line);
    for (int i = 0; i < T; i++) {
      String[] arr = br.readLine().split(" ");
      int L = Integer.parseInt(arr[0]);
      int W = Integer.parseInt(arr[1]);
      int H = Integer.parseInt(arr[2]);
      System.out.print("Case " + (i + 1) + ": ");
      if (L > 20 || W > 20 || H > 20)
        System.out.println("bad");
      else
        System.out.println("good");
    }
  }
}
