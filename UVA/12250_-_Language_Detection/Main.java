import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int i = 1;
    while (!(line = br.readLine()).equals("#")) {
      System.out.print("Case " + i + ": ");
      if (line.equals("HELLO"))
        System.out.println("ENGLISH");
      else if (line.equals("HOLA"))
        System.out.println("SPANISH");
      else if (line.equals("HALLO"))
        System.out.println("GERMAN");
      else if (line.equals("BONJOUR"))
        System.out.println("FRENCH");
      else if (line.equals("CIAO"))
        System.out.println("ITALIAN");
      else if (line.equals("ZDRAVSTVUJTE"))
        System.out.println("RUSSIAN");
      else
        System.out.println("UNKNOWN");
      i++;
    }
  }
}

