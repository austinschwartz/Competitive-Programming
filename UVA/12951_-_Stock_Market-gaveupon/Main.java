import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] s = line.split(" ");
      int N = Integer.parseInt(s[0]);
      int C = Integer.parseInt(s[1]);
      int[] prices = new int[N];
      s = br.readLine().split(" ");
      for (int i = 0; i < N; i++)
        prices[i] = Integer.parseInt(s[i]);
      int[] stocks = new int[n];
      boolean boughtStock = false;
      int max = -1;
      for (int i = 1; i < N; i++) {
        if (boughtStock == false) {
          stocks[i-1]
        } else {
          
        }
        if (stocks[i] > max)
          max = stocks[i];
      }
    }
  }
}
