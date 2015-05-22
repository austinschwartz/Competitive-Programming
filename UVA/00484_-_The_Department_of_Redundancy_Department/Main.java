import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    int i;
    while (in.hasNextInt()) {
      i = in.nextInt();
      if (map.containsKey(i))
        map.put(i, map.get(i) + 1);
      else
        map.put(i, 1);
    }
    for (int key : map.keySet()) {  
      System.out.println(key + " " + map.get(key));
    }
  }
}
