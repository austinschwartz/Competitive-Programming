import java.util.*;
import java.io.*;

class Main {
  public static String[] amps = {"","1","22","333","4444","55555",
              "666666","7777777","88888888","999999999"};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int x = 0; x < N; x++) {
      if (x > 0)
        System.out.println();
      br.readLine();
      int a = Integer.parseInt(br.readLine());
      int f = Integer.parseInt(br.readLine());
      for (int i = 0; i < f; i++) {
        if (i > 0)
          System.out.println();
        for (int j = 1; j <= a; j++) {
          System.out.println(amps[j]);
        }
        for (int j = a-1; j > 0; j--) {
          System.out.println(amps[j]);
        }
      }
    }
  }
}
