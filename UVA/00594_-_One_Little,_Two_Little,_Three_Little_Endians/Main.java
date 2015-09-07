import java.util.*;
import java.io.*;

class Main {
  public static int reverseEndian(int i) {
    return Integer.reverseBytes(i);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line + " converts to " + reverseEndian(Integer.parseInt(line)));
    }
  }
}
