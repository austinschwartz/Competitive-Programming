import java.util.*;
import java.io.*;

class Main {
  public static int turn(int start, int end, int counterclockwise) {
    if (counterclockwise == 1) {
      int temp = start;
      start = end;
      end = temp;    
    }

    if (start < end) {
      return 40 + start - end;    
    } else {
      return start - end;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      int[] ns = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
        ns[i] = Integer.parseInt(arr[i]);
      }
      if (ns[0] == 0 && ns[1] == 0 && ns[2] == 0 && ns[3] == 0)
        return;
      
      int res = 3 * 40;
      res += turn(ns[0], ns[1], 0);
      res += turn(ns[1], ns[2], 1);
      res += turn(ns[2], ns[3], 0);

      res = res * 360 / 40;
      System.out.println(res);
    } 
  }
}
