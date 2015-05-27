import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0)
        break;
      int l = Integer.parseInt(br.readLine());
      int[] nodes = new int[n];
      int[][] edges = new int[];

      for (int i = 0; i < l; i++) {
        String[] arr = br.readLine().split(" ");
        int n1 = Integer.parseInt(arr[0]);
        int n2 = Integer.parseInt(arr[1]);
        List<Integer> edge = new ArrayList<
      }
      System.out.println("??");
    }
  }
}
