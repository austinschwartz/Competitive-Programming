// Gave up on this one. I need to brush up on my graph knowledge

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
      int[] lights = new int[N];
      for (int j = 0; j < N; j++) {
        lights[j] = Integer.parseInt((String)tk.nextElement());
      }
      for (int j = 0; j < N - 1; j++) {
        
      }
    }
  }
}
