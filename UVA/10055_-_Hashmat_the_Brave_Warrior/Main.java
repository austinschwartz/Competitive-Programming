import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      long a = Long.parseLong(arr[0]);
      long b = Long.parseLong(arr[1]);
      if (a > b)
        System.out.println(a - b);
      else 
        System.out.println(b - a);
    }
  }
}
