import java.util.*;
import java.io.*;

class Main {
  public static int GCD(int a, int b) {
    while (a != 0 && b != 0) {
      int c = b; 
      b = a % b;
      a = c;
    }
    return a + b;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    while ((N = Integer.parseInt(br.readLine())) != 0) {
      int G = 0;
      for (int i = 1; i < N; i++) {
        for (int j = i+1; j <= N; j++) {
          G += GCD(i, j);
        }
      }
      System.out.println(G);
    }
  }
}
