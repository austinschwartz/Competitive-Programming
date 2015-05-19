import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      int count = 0;
      boolean start = false;
      char[] arr = line.toLowerCase().toCharArray();
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] >= 'a' && arr[i] <= 'z') {
          if (!start) {
            count++;
            start = true;
          }
        } else {
          start = false;
        }
      }
      System.out.println(count);
    }
  }
}
