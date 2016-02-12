import java.util.*;
import java.io.*;

class Main {
  public static int lis(int[] nums, int N) {
    return -1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] correct = br.readLine().split(" ");
    int[] correctNums = new int[N];
    for (int i = 0; i < N; i++) {
      correctNums[i] = Integer.parseInt(correct[i]);
    }

    String line;
    while ((line = br.readLine()) != null && !line.equals("")) {
      int[] nums = new int[N];
      String[] incorrect = line.split(" ");
      int[] incorrectNums = new int[N];
      for (int i = 0; i < N; i++) {
        incorrectNums[i] = Integer.parseInt(incorrect[i]);
      }

    }
  }
}
