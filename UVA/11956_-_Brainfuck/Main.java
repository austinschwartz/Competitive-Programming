import java.util.*;
import java.io.*;

class Main {
  public static String toHex(int x) {
    String hex = "0123456789ABCDEF";
    String res = "";
    for (int i = 0; i < 2; ++i) {
      res = hex.charAt(x % 16) + res;
      x /= 16;
    }
    return res;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      int[] tape = new int[100];
      int p = 0;
      String line = br.readLine();
      char[] chars = line.toCharArray();
      for (int k = 0; k < chars.length; k++) {
        char ch = chars[k];
        int temp;
        switch (ch) {
          case '>': p = (p + 1) % 100;
                    break;
          case '<': p = (p - 1 + 100) % 100;
                    break;
          case '+': tape[p] = (tape[p] + 1) % 256;
                    break;
          case '-': tape[p] = (tape[p] - 1 + 256) % 256;
                    break;
        }
      }
      System.out.print("Case " + i + ": ");
      for (int j = 0; j < 100; j++) {
        System.out.print(toHex(tape[j]));
        if (j < 99)
          System.out.print(" ");
      }
      System.out.println();
    }
  }
}
