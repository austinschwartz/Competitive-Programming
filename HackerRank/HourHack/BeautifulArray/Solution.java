import java.util.*;
import java.io.*;

class Solution {
  public static int beautiful(int[] arr, int n, int k, int l) {
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int k = Integer.parseInt(line[1]);
    int l = Integer.parseInt(line[2]);
    String[] s = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }
    System.out.println(beautiful(arr, n, k, l));
  }
}
