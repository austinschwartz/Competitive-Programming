import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int T = Integer.parseInt(line);
    int total = 0;
    for (int i = 0; i < T; i++) {
      line = br.readLine();
      if (line.equals("report")) {
        System.out.println(total);
      } else {
        String[] arr = line.split(" ");
        int amt = Integer.parseInt(arr[1]);
        total += amt;
      }
    }
  }
}
