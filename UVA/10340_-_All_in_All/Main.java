import java.util.*;
import java.io.*;

class Main {
  public static boolean contains(char[] s, char[] t) {
    if (s.length > t.length) return false;
    int i = 0;
    for (int j = 0; j < t.length; j++) {
      if (i >= s.length || j >= t.length)
        break;
      if (t[j] == s[i])
        i++;
    }
    if (i == s.length)
      return true;
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] both = line.split(" ");
      char[] s = both[0].toCharArray();
      char[] t = both[1].toCharArray();
      System.out.println(contains(s, t) ? "Yes" : "No");
    }
  }
}
