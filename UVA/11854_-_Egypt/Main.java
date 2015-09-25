import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String l;
    String[] line;
    while (!(l = br.readLine()).equals("0 0 0") && l != null) {
      line = l.split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      int c = Integer.parseInt(line[2]);
      if (a == 0 && b == 0 && c == 0)
        break;
      if (((a * a) + (b * b) == (c * c)) ||
          ((a * a) + (c * c) == (b * b)) ||
          ((b * b) + (c * c) == (a * a)))
        System.out.println("right");
      else
        System.out.println("wrong");
    }
  }
}
