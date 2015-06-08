import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder(25000);
    String line;
    boolean first = true;
    while (!(line = br.readLine()).equals("0 0")) {
      if (first == false)
        sb.append("-\n");
      StringTokenizer stk = new StringTokenizer(line);
      int S = Integer.parseInt(stk.nextToken());
      int B = Integer.parseInt(stk.nextToken());
      int[] left = new int[S + 1];
      int[] right = new int[S + 1];
      for (int i = 1; i <= S; i++) {
        left[i] = i - 1;
        right[i] = i + 1;
      }
      for (int i = 0; i < B; i++) {
        stk = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());
        int newL = -1;
        int newR = -1;
        if (left[L] > 0)
          newL = left[L];
        if (right[R] <= S)
          newR = right[R];
        sb.append((newL > 0 ? newL : "*") + " " + (newR > 0 ? newR : "*") + "\n");
        if (right[R] <= S)
          left[right[R]] = left[L];
        if (left[L] <= S)
          right[left[L]] = right[R];
      }
      first = false;
      if (sb.length() >= 10000) {
        wr.write(sb.toString());
        sb = new StringBuilder(25000);
      }
    }
    wr.write(sb.toString());
    wr.flush();
    wr.close();
  }
}
