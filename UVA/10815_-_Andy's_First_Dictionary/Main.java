import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    Set<String> set = new TreeSet<String>();
    StringBuilder sb = new StringBuilder();
    while ((line = br.readLine()) != null) {
      String[] arr = line.toLowerCase().split("[^a-z]+");
      for (String a : arr) {
        boolean good = true;
        for (int i = 0; i < a.length(); i++) {
          if (!Character.isLetter(a.charAt(i)))
            good = false;
        }
        if (good && a.length() > 0)
          set.add(a);
      }
    }
    for (String x : set)
      System.out.println(x);
  }
}
