import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      int v = Integer.parseInt(arr[0]);
      int t = Integer.parseInt(arr[1]);
      System.out.println(((2 * v) * t));
    }
  }
}
