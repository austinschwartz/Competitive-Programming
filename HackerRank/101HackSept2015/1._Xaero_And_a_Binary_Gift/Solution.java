//
// Note: this code is awful
//
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static int swaps(String s1, String s2) {
    if (s1.length() != s2.length()) return -1;
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    Map<Integer, Character> map1 = new HashMap<Integer, Character>();
    Map<Integer, Character> map2 = new HashMap<Integer, Character>();

    int zeroscount = 0;
    for (int i = 0; i < c1.length; i++) {
      map1.put(i, c1[i]);
      map2.put(i, c2[i]);
      if (c1[i] == '0')
        zeroscount++;
      if (c2[i] == '0')
        zeroscount--;
    }

    if (zeroscount != 0)
      return -1;

    int diffcount = 0;
    for (int i = 0; i < c1.length; i++) {
      if (map1.get(i) != map2.get(i))
        diffcount++;
    }

    return diffcount / 2;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    System.out.println(swaps(s1, s2));
  }
}
