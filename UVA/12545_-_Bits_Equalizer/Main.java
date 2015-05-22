import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] start;
    char[] end;
    int moves;
    int ones;
    int zeros;
    int onetozero;
    int zerotoone;
    int qs;
    int C = Integer.parseInt(br.readLine());
    for (int i = 0; i < C; i++) {
      moves = 0;
      ones = 0;
      zeros = 0;
      onetozero = 0;
      zerotoone = 0;
      qs = 0;
      start = br.readLine().toCharArray();
      end = br.readLine().toCharArray();
      for (int j = 0; j < start.length; j++) {
        if (start[j] == '1' && end[j] == '0') onetozero++;
        if (start[j] == '0' && end[j] == '1') zerotoone++;
        if (start[j] == '?') qs++;
        if (start[j] == '0') zeros++;
        if (start[j] == '1') ones++;
      }
      
      System.out.println(onetozero + " " + zerotoone + " " + qs + " " + zeros + " " + ones + " " + Arrays.toString(start) + " " + Arrays.toString(end));
    }

  }
}
