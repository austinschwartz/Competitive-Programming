import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    while ((line = br.readLine()) != null) {
      char[] arr = line.replaceAll("\\s+", "").toCharArray();
      Arrays.sort(arr);
      String x = new String(arr);
      if (map.containsKey(x)) {
        ArrayList<String> list = map.get(x);
        list.add(line);
      } else {
        ArrayList<String> list = new ArrayList<String>();
        list.add(line);
        map.put(x, list);
      }
    }
    for (String key : map.keySet()) {
      ArrayList<String> lst = map.get(key);
      System.out.println(key);
      for (String a : lst)
        System.out.println(" " + a);
    }
  }
}
