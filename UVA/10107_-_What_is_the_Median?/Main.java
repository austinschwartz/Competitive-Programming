import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    List<Integer> ints = new ArrayList<Integer>();
    int x;
    while (in.hasNextInt()) {
      x = in.nextInt();
      ints.add(x);
      Collections.sort(ints);
      int size = ints.size();
      int median;
      if (size == 0)
        return;
      if (size == 1)
        median = ints.get(0);
      else
        median = size % 2 == 0 ? ((ints.get((size - 1) / 2) + ints.get(size / 2)) / 2) :
                                  (ints.get((size - 1) / 2));
      System.out.println(median);
    }
  }
}
