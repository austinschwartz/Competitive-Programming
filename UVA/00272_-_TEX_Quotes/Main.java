import java.util.*;
import java.io.*;

class Main {

  static int left = 1;
  public static String texify(String input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '\"') {
        if (left == 0) {
          sb.append("''");
          left = 1;
        } else {
          sb.append("``");
          left = 0;
        }
      } else {
        sb.append(input.charAt(i));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(texify(line));
    }
  }
}
