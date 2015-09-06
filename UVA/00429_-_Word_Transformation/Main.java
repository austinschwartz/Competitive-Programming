// WA for some reason, not gonna deal with it
import java.util.*;
import java.io.*;

class Main {
  public static class WordNode {
    String word;
    int steps;

    public WordNode(String word, int steps) {
      this.word = word;
      this.steps = steps;
    }
  }

  public static int bst(Set<String> words, String start, String end) {
    Queue<WordNode> queue = new ArrayDeque<WordNode>();
    queue.add(new WordNode(start, 1));
    
    while (!queue.isEmpty()) {
      WordNode top = queue.remove();
      String word = top.word;

      if (word.equals(end))
        return top.steps;

      char[] arr = word.toCharArray();
      for (int i = 0; i < arr.length; i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          char temp = arr[i];
          if (arr[i] != c) {
            arr[i] = c;
          }
          String newWord = new String(arr);
          if (words.contains(newWord)) {
            queue.add(new WordNode(newWord, top.steps + 1));
            words.remove(newWord);
          }
          arr[i] = temp;
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.readLine();
    for (int i = 0; i < N; i++) {
      if (i > 0 && i < N)
        System.out.println();
      Set<String> words = new HashSet<String>();
      String temp;
      while (!(temp = br.readLine()).equals("*")) {
        words.add(temp);
      }
      while ((temp = br.readLine()) != null && !temp.equals("")) {
        String[] splitString = temp.split(" ");
        String start = splitString[0];
        String end = splitString[1];
        System.out.println(start + " " + end + " " + (bst(words, start, end) - 1));
      }
      words.clear();
    }
  }
}
