import java.util.*;
import java.io.*;

class Main {
  static int[] arr = new int[99999]; 
  public static void main(String[] args) throws Exception {
    arr[0] = 1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long s;
    while ((s = Long.parseLong(br.readLine())) != 0) {
      long forgottenpage = 0;
      long pagecount = 0;
      int i = 1;
      while (forgottenpage == 0) {
        if (arr[i] == 0)
          arr[i] = (i + 1) + arr[i - 1];
        if (arr[i] > s)
          forgottenpage = arr[i];
        i++;
      }
      pagecount = i;
      forgottenpage = forgottenpage - s;
      System.out.println(forgottenpage + " " + pagecount);
    }
  }
}
