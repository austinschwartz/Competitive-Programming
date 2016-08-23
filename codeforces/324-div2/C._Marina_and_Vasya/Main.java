import java.util.*;
import java.io.*;

public class Main {
  public static String f(char[] a, char[] b, int n, int t) {
    int dif = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i])
        dif++;
    }
    if (t < dif)
      return "-1";
    char[] c = new char[n];
    int different = 0;
    int ti = t;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        different++;
        char x = 'a';
        while ((x == a[i] || x == b[i]) && x <= 'z') {
          x++;
        }
        if (x > 'z')
          return "-1";
        c[i] = x;
      } else {
        ti--;
        c[i] = a[i];
      }
    }
    for (int i = 0; i < n; i++) {
      int alt = 0; // a = 0, b = 1;
      if (c[i] != a[i] && c[i] != b[i]) {
        if (different > t) {
          c[i] = (alt == 0 ? a[i] : b[i]);
          alt = (alt == 0 ? 1 : 0);
          different--;
        }
      }
    }
    return new String(c);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int t = Integer.parseInt(line[1]);
    String s1 = br.readLine();
    String s2 = br.readLine();
    System.out.println(f(s1.toCharArray(), s2.toCharArray(), n, t));
  }
}
