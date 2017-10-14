import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null && !line.equals("")) {
      int N = Integer.parseInt(line);
      Stack<Integer> stack = new Stack<Integer>();
      Queue<Integer> queue = new LinkedList<Integer>();
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      int stackMatches = 0;
      int queueMatches = 0;
      int pqMatches = 0;
      int totalMatches = 0;
      for (int i = 0; i < N; i++) {
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        if (m == 1) {
          stack.push(x);
          queue.add(x);
          pq.offer(-x);
        } else if (m == 2) {
          int st = 0, q = 0, p = 0;
          try {
            st = stack.pop();
            q = queue.remove();
            p = pq.poll();
          } catch (Exception e) {
            System.out.println("impossible");
            continue;
          }
          if (st == x) stackMatches++;
          if (q == x) queueMatches++;
          if (-p == x) pqMatches++;
          totalMatches++;
        }
      }
      if (totalMatches == pqMatches && 
          totalMatches != stackMatches && 
          totalMatches != queueMatches)
        System.out.println("priority queue");
      else if (totalMatches != pqMatches && 
                 totalMatches == stackMatches && 
                 totalMatches != queueMatches)
        System.out.println("stack");
      else if (totalMatches != pqMatches && 
                 totalMatches != stackMatches && 
                 totalMatches == queueMatches)
        System.out.println("queue");
      else if (totalMatches != pqMatches &&
                totalMatches != stackMatches &&
                totalMatches != queueMatches)
        System.out.println("impossible");
      else
        System.out.println("not sure");
    }
  }
}
