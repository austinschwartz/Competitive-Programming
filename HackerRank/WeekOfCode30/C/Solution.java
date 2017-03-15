import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<String> curr = new ArrayList<String>();
    List<String> prev = new ArrayList<String>();
    prev.add("");
    for (int i = 0; i < n; i++) {
      curr = new ArrayList<String>();
      for (String pStr : prev) {
        for (int j = 0; j < 26; j++) {
          char c = (char)('a' + j);
          if (c == 'y') continue;
          if (i == 0 || opposite(pStr.charAt(pStr.length() - 1), c))
            curr.add(pStr + c);
        }
      }
      prev = curr;
    }
  }

  public static boolean opposite(char a, char b) {
    return (isVowel(a) && isCons(b)) ||
           (isCons(a) && isVowel(b));
  }

  public static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
  }

  public static boolean isCons(char c) {
    return !isVowel(c);
  }
}
