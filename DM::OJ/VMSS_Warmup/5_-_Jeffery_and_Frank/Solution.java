import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] first = br.readLine().split(" ");
    int N = Integer.parseInt(first[0]);
    int R = Integer.parseInt(first[1]);
    int S = Integer.parseInt(first[2]);
    String[] line;
    String[] names = new String[N];
    int[] values = new int[N];
    int[] costs = new int[N];
    int[] volumes = new int[N];
    for (int i = 0; i < N; i++) {
      line = br.readLine().split(" ");
      String E = line[0];
      int V = Integer.parseInt(line[1]);
      int A = Integer.parseInt(line[2]);
      int B = Integer.parseInt(line[3]);
      names[i] = E;
      values[i] = V;
      costs[i] = A;
      volumes[i] = B;
    }
  }
}
