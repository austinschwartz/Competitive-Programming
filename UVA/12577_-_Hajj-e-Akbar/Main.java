import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int i = 1;
    while (!(line = br.readLine()).equals("*")) {
      System.out.print("Case " + i + ": ");
      if (line.equals("Hajj")) {
        System.out.println("Hajj-e-Akbar");
      } else if (line.equals("Umrah")) {
        System.out.println("Hajj-e-Asghar");
      }
      i++;
    }
     
  }
}
