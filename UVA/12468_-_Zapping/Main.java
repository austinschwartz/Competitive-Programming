import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).equals("-1 -1")) {
      String[] arr = line.split(" ");
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      int count = Math.min(Math.abs(a-b), Math.abs(b-a));
      System.out.println(Math.min(Math.abs((count - 100) % 100), count));
    }
  }
}
