import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      if (i > 0)
        System.out.println();
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      br.readLine();
      int N = Integer.parseInt(br.readLine());
      for (int j = 0; j < N; j++) {
        String original = br.readLine();
        char[] word = original.toCharArray();
        Arrays.sort(word);
        String w = new String(word);
        if (map.containsKey(w)) {
          List<String> lst = map.get(w);
          lst.add(original);
        } else {
          List<String> lst = new ArrayList<String>();
          lst.add(original);
          map.put(w, lst);
        }
      }
      String line;
      while (((line = br.readLine()) != null) && !line.equals("END")) {
        String test = line;
        char[] word = test.toCharArray();
        Arrays.sort(word);
        String w = new String(word);
        System.out.println("Anagrams for: " + test);
        if (map.containsKey(w)) {
          List<String> set = map.get(w);
          int index = 1;
          for (String str : set) {
            System.out.printf("  %d) %s\n", index, str);
            index++;
          }
        } else {
          System.out.println("No anagrams for: " + test); 
        }
      }
    }
  }
}
