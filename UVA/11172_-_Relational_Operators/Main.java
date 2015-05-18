import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int N = Integer.parseInt(line);
    for (int i = 0; i < N; i++) {
      line = br.readLine();
      String[] arr = line.split(" ");
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      if (a == b)
        System.out.println("=");
      else if (a > b)
        System.out.println(">");
      else
        System.out.println("<");
    }
  }
}
