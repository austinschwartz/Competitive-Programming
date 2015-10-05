import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] paved = new int[n*n];
    int[] pavedv = new int[n];
    int[] pavedh = new int[n];
    Arrays.fill(paved, -1);
    Arrays.fill(pavedv, -1);
    Arrays.fill(pavedh, -1);
    ArrayList<Integer> lst = new ArrayList<Integer>();
    for (int i = 1; i <= n * n; i++) {
      String[] line = br.readLine().split(" ");
      int h = Integer.parseInt(line[0]);
      int v = Integer.parseInt(line[1]);
      if (pavedh[h-1] == -1 && pavedv[v-1] == -1) {
        pavedh[h-1] = i;
        pavedv[v-1] = i;
        paved[h-1] = i;
        paved[v-1] = i;
        lst.add(i);
      }
    }
    for (int i = 0; i < lst.size(); i++) {
      System.out.print(lst.get(i));
      if (i < lst.size() - 1)
        System.out.print(" ");
    }
    System.out.println();
  }
}
