import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }
    String[] hb = {"Happy", "birthday", "to", "you", 
                   "Happy", "birthday", "to", "you", 
                   "Happy", "birthday", "to", "Rujia",
                   "Happy", "birthday", "to", "you"};
    for (int l = 0; l < (Math.ceil(N / 16.0)); l++) {
      for (int j = 0; j < hb.length; j++) {
        System.out.println(arr[(((16 * l) + j) % N)] + ": " + hb[j]); 
      }
    }
  }
}
