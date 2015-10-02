import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null && !line.equals("DONE")) {
      String updated = line.toLowerCase().replaceAll("[^a-z]", "");
      boolean isPalindrome = true;
      for (int i = 0, j = updated.length() - 1; i < j; i++, j--) {
        if (updated.charAt(i) != updated.charAt(j))
          isPalindrome = false;
      }
      if (isPalindrome)
        System.out.println("You won't be eaten!");
      else
        System.out.println("Uh oh..");
    }
  }
}
