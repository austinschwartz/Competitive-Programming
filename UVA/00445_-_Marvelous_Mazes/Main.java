import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      if (line.equals("")) {
        System.out.println("");
        line = br.readLine();
      }
      char[] arr = line.toCharArray();
      int num = 0;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '!')
          System.out.println();
        else if (Character.isDigit(arr[i])) {
          num = arr[i] - '0';
          i++;
          while (Character.isDigit(arr[i])) {
            num += arr[i] - '0';
            i++;
          }

          for (int j = 0; j < num; j++) {
            if (arr[i] == 'b')
              System.out.print(" ");
            else
              System.out.print(arr[i]);
          }
        }
      }
        System.out.println();
    }
  }
}
