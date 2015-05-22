import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    Main main = new Main();
    while ((line = br.readLine()) != null) {
      char[] arr = line.toCharArray();
      Deque<String> l = new ArrayDeque<String>();
      StringBuilder sb = new StringBuilder();
      boolean front = false;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '[') {
          if (front)
            l.addFirst(sb.toString());
          else
            l.addLast(sb.toString());
          sb = new StringBuilder();
          front = true;
        } else if (arr[i] == ']') {
          if (front)
            l.addFirst(sb.toString());
          else
            l.addLast(sb.toString());
          sb = new StringBuilder();
          front = false;
        } else {
          sb.append(arr[i]);
        }
      }
      if (front)
        l.addFirst(sb.toString());
      else
        l.addLast(sb.toString());
      StringBuilder sb2 = new StringBuilder();
      for (String a : l)
        sb2.append(a);
      System.out.println(sb2.toString());
    }
  }
}
