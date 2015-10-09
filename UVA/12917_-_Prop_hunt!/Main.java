import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String[] m;
    while ((line = br.readLine()) != null) {
      m = line.split(" ");
      int P = Integer.parseInt(m[0]);
      int H = Integer.parseInt(m[1]);
      int O = Integer.parseInt(m[2]);
      int N = O - P;
      if (H > N)
        System.out.println("Hunters win!");
      else
        System.out.println("Props win!");
    }
  }
}
