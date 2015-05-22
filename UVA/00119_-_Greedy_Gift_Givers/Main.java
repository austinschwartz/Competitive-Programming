import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int x = 1;
    while ((line = br.readLine()) != null) {
      if (x == 0)
        System.out.println();
      x = 0;
      int N = Integer.parseInt(line);
      String[] names = br.readLine().split(" ");
      Map<String, Integer> map = new LinkedHashMap<String, Integer>();
      for (int j = 0; j < N; j++)
        map.put(names[j], 0);
      for (int i = 0; i < N; i++) {
        String[] arr = br.readLine().split(" ");
        String name =  arr[0];
        int amt = Integer.parseInt(arr[1]);
        int pplcount = Integer.parseInt(arr[2]);
        for (int j = 0; j < pplcount; j++) {
          String person = arr[3 + j];
          int actualamt = amt / pplcount;
          if (map.containsKey(person))
            map.put(person, map.get(person) + actualamt);
          else
            map.put(person, actualamt);
          if (map.containsKey(name))
            map.put(name, map.get(name) - actualamt);
          else
            map.put(name, actualamt * -1);
        }
      }
      for (String key : map.keySet()) {
        System.out.println(key + " " + map.get(key));
      }
    }
  }
}
