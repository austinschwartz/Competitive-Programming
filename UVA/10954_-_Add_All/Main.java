import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    while ((N = Integer.parseInt(br.readLine())) != 0) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      StringTokenizer stk = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        int x = Integer.parseInt(stk.nextToken());
        pq.add(x);
      }
      int sum = 0;
      for (int i = 0; i < N - 1; i++) {
        int a = pq.poll();
        int b = pq.poll();
        int c = a + b;
        sum += c;
        pq.add(c);
      }
      System.out.println(sum);
    }
  }
}
