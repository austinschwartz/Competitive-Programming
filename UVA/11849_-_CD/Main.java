import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).equals("0 0")) {
      String[] arr = line.split(" ");
      int N = Integer.parseInt(arr[0]);
      int M = Integer.parseInt(arr[1]);
      TreeSet<Integer> set = new TreeSet<Integer>();
      for (int i = 0; i < N; i++) {
        set.add(Integer.parseInt(br.readLine()));
      }
      int count = 0;
      for (int j = 0; j < M; j++) {
        int x = Integer.parseInt(br.readLine());
        if (set.contains(x)) count++;
      }
      System.out.println(count);
    }
  }
}
