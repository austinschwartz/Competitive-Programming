import java.util.*;
import java.io.*;

public class Main {
  public static int countOnes(int x) {
    int count = 0;
    for (int i = 1; x > 0; x = x >>> 1) {
      if ((i & x) == 1)
        count++;
    }
    return count;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    System.out.println(countOnes(x));
  }
}
