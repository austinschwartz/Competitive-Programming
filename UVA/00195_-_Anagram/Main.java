import java.util.*;
import java.io.*;

class Main {
  public static List<String> permutations(String word, int n) {
    List<String> list = new ArrayList<String>();
    if (n == 0) {
      list.add("");
    } else {
      List<String> prev = permutations(word, n - 1);
      for (String str : prev) {
        for (int i = 0; i <= str.length(); i++) {
          list.add(str.substring(0, i) + word.charAt(n - 1) + str.substring(i));
        }
      }
    }
    return list;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      Set<String> wordSet = new HashSet<>(permutations(word, word.length()));
      List<String> words = new ArrayList<>(wordSet);
      Collections.sort(words);
      for (String w : words)
        System.out.println(w);
    }
  }
}
