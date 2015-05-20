import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int n = Integer.parseInt(line);
    TreeMap<String, TreeSet<String>> map = new TreeMap<String, TreeSet<String>>();
    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split(" ", 2);
      if (map.containsKey(arr[0])) {
        TreeSet<String> temp = map.get(arr[0]);
        for (int j = 1; j < arr.length; j++) {
          temp.add(arr[j]);
        }
        map.put(arr[0], temp);
      } else {
        TreeSet<String> set = new TreeSet<String>();
        for (int k = 1; k < arr.length; k++) {
          set.add(arr[k]);
        }
        map.put(arr[0], set);
      }
    }
    for (String key : map.keySet()) {
      System.out.println(key + " " + map.get(key).size());
    }
  }
}
