import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int n = Integer.parseInt(line);
    for (int i = 0; i < n; i++) {
      line = br.readLine();
      if (line.equals("1") || line.equals("4") || line.equals("78"))
        System.out.println("+");
      else if (line.endsWith("35"))
        System.out.println("-");
      else if (line.startsWith("190"))
        System.out.println("?");
      else
        System.out.println("*");
    }
  }
}
