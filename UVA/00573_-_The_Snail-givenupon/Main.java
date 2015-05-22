import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      int H = Integer.parseInt(arr[0]); // height
      int U = Integer.parseInt(arr[1]); // distance the snail can climb during day
      int D = Integer.parseInt(arr[2]); // distance the snail falls during night
      int F = Integer.parseInt(arr[3]); // fatigue
      if (H == 0)
        return;

      double height = 0;
      double decrease = U * (F * .01);
      int day = 0;
      boolean first = true;
      while (height <= H && (day == 0 || height >= 0)) {
        day++;
        height += U;
        if (height > H)
          break;
        height -= D;
        U -= decrease;
        U = Math.max(0, U);
      }
      System.out.print(height > 0 ? "success" : "failure");
      System.out.println(" on day " + day);
    }
  }
}
