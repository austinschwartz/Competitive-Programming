import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    while (true) {
      int N = in.nextInt();
      final int M = in.nextInt();
      if (N == 0 && M == 0) {
        break;
      }
      Integer[] nums = new Integer[N];
      for (int i = 0; i < N; i++) {
        nums[i] = in.nextInt();
      }
      Arrays.sort(nums, new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
          int amod = Math.abs(a % M) * (a < 0 ? -1 : 1);
          int bmod = Math.abs(b % M) * (b < 0 ? -1 : 1);
          if (amod != bmod)
            return amod - bmod;
          boolean aeven = (Math.abs(a) % 2) == 0 ? true : false;
          boolean beven = (Math.abs(b) % 2) == 0 ? true : false;
          if (aeven && !beven)
            return 1;
          else if (!aeven && beven)
            return -1;
          if (aeven && beven) {
            if (a <= b) return  -1;
            if (a > b) return 1;   
          }
          else if (!aeven && !beven) {
            if (a > b) return -1;
            if (a <= b) return 1;
          }        
          return 1;
        }
      });
      System.out.println(N + " " + M);
      for (int j = 0; j < N; j++) {
        System.out.println(nums[j]);
      }
    }
    System.out.println("0 0");
  }
}
