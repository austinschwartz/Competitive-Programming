import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    Map<String, Integer> map = new TreeMap<String, Integer>();
    int m = Integer.parseInt(arr[0]);
    int n = Integer.parseInt(arr[1]);
    for (int i = 0; i < m; i++) {
      arr = br.readLine().split(" ");
      int amt = Integer.parseInt(arr[1]);
      map.put(arr[0], amt);
    }
    for (int j = 0; j < n; j++) {
      int sum = 0;
      StringBuilder sb = new StringBuilder();
      String desc;
      while (!(desc = br.readLine()).equals("."))
        sb.append(desc + " ");
      desc = sb.toString();
      for (String word : desc.split("[ ]+")) {
         if (map.containsKey(word))
           sum += map.get(word);
      }
      System.out.println(sum);
    }
  }
}
