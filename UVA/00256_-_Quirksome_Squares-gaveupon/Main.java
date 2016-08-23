import java.util.*;
import java.io.*;

class Main {
  public static String s = "9999999999";
  public static String[] twos = new String[]{"00", "01", "81"};
  public static String[] fours = new String[]{"0000", "0001", "2025", "3025", "9801"};
  public static String[] sixes = new String[]{"000000", "000001", "088209", "494209", "998001"};
  public static String[] eights = new String[]{"00000000", "00000001", "04941729", "07441984", "24502500", "25502500", "52881984", "60481729", "99980001"};
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N;
    int in = 0;
    while ((line = br.readLine()) != null && !line.equals("")) {
      N = Integer.parseInt(line);
      switch (N) {
        case 2:
          print(twos);
          break;
        case 4:
          print(fours);
          break;
        case 6:
          print(sixes);
          break;
        case 8:
          print(eights);
          break;
      }
    }
  }
  public static void print(String[] strs) {
    for (String str : strs)
      System.out.println(str);
  }
}
