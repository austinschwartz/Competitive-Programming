import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] line = br.readLine().split(" ");
      int n = Integer.parseInt(line[0]);
      int x = Integer.parseInt(line[1]);
 
      int count = 0;
      for (int i = 1; i <= n; i++) {
        if ((x % i == 0) && (x / i <= n)) {
          count++;
        }
      }     

      System.out.println(count);
   }
}
