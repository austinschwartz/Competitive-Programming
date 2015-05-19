import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int N = Integer.parseInt(line);
    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (word.length() == 3) {
        int one = 0;
        int two = 0;
        if (word.charAt(0) == 'o') one++;
        if (word.charAt(0) == 't') two++;
        if (word.charAt(1) == 'n') one++;
        if (word.charAt(1) == 'w') two++;
        if (word.charAt(2) == 'e') one++;
        if (word.charAt(2) == 'o') two++;
        
        if (one > two)
          System.out.println("1");
        else
          System.out.println("2");
      } else if (word.length() == 5) {
          System.out.println("3");
      } else {
        System.out.println("?"); 
      }
    }
  }
}
