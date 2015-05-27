import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, String> map = new HashMap<String, String>();
    String line;
    while (!(line = br.readLine()).equals("")) {
      String[] arr = line.split(" ");
      String translation = arr[0];
      String word = arr[1];
      map.put(word, translation);
    }
    
    while ((line = br.readLine()) != null) {
      if (map.containsKey(line)) {
        System.out.println(map.get(line));
      } else {
        System.out.println("eh");  
      }
    }
  }
}
