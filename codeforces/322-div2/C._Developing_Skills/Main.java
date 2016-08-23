import java.util.*;
import java.io.*;

public class Main {
  public static int score(Integer[] a, int n) {
    int s = 0;
    for (int i = 0; i < n; i++) {
      s += Math.floor(((double)(a[i])) / 10.0); 
    }
    return s;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int k = Integer.parseInt(line[1]);
    Integer[] a = new Integer[n];
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt((String)stk.nextToken());

    Arrays.sort(a, new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return (new Integer((o2 % 10)).compareTo(new Integer((o1 % 10))));
      }
    });

    for (int i = 0; i < n; i++) {
      while (k > 0 && a[i] != 100 && a[i] % 10 != 0) {
        a[i]++;
        k--;
      }
    }
    for (int i = 0; i < n; i++) {
      while (k > 0 && a[i] != 100) {
        a[i]++;
        k--;
      }
    }
    System.out.println(score(a, n));
  }
}
