import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int i = 1;
    while (true) {
      int n = in.nextInt();
      if (n == 0)
        break;
      int[] stacks = new int[n];
      int total = 0;
      int min = 0;
      for (int k = 0; k < n; k++) {
        int x = in.nextInt();
        total += x;
        stacks[k] = x;
      }
      int avg = total / n;
      for (int j = 0; j < n; j++) { 
        if (stacks[j] > avg)
          min += (stacks[j] - avg);
      }
      System.out.println("Set #" + i + "\nThe minimum number of moves is " + min + ".\n");
      i++;
    }
  }
}
