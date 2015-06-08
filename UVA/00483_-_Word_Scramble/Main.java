import java.util.*;
import java.io.*;

class Main {
  public static char[] a;
  public static void reverse(int start, int end) {
    char temp;
    while ( start <= end ) {
      temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      a = line.toCharArray();
      int space = -1;
      for (int i = 0; i <= a.length; i++) {
        if (i == a.length || a[i] == ' ') {
          reverse(space + 1, i-1);
          space = i;
        }
      }
      System.out.println(a);
    }
  }
}
