import java.util.*;
import java.io.*;

class Main {
  public static int getPos(String[] instructions, int i) {
      if (instructions[i].equals("LEFT"))
        return -1;
      else if (instructions[i].equals("RIGHT"))
        return 1;
      else {
        String[] s = instructions[i].split(" ");
        int x = Integer.parseInt(s[2]);
        return getPos(instructions, x-1);
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int position = 0;
      int n = Integer.parseInt(br.readLine());
      String[] instructions = new String[n];
      for (int j = 0; j < n; j++)
        instructions[j] = br.readLine();
      for (int k = 0; k < n; k++)
        position += getPos(instructions, k);
      System.out.println(position);
    }
  }
}
