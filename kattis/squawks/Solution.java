import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    public static class Node {
        ArrayList<Node> neighbors;
        public int i;
        public BigInteger squawks;
        public Node(int i) {
            this.i = i;
            this.squawks = BigInteger.ZERO;
            this.neighbors = new ArrayList<Node>();
        }
    }
    public static Node[] nodes;
    public static int n, m, s, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        s = Integer.parseInt(line[2]);
        t = Integer.parseInt(line[3]);
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
          nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
          line = br.readLine().split(" ");
          int x = Integer.parseInt(line[0]);
          int z = Integer.parseInt(line[1]);
          Node a = nodes[x];
          Node b = nodes[z];
          a.neighbors.add(b);
          b.neighbors.add(a);
        }
        Queue<Node> queue = new LinkedList<Node>();
        nodes[s].squawks = BigInteger.ONE;
        queue.add(nodes[s]);
        BigInteger tot;
        for (int i = 0; i < t; i++) {
          Queue<Node> tempQueue = new LinkedList<Node>();
          tempQueue.addAll(queue);
          queue.clear();
          tot = BigInteger.ZERO;
          while (!tempQueue.isEmpty()) {
            Node temp = tempQueue.remove();
            BigInteger z = temp.squawks;
            temp.squawks = BigInteger.ZERO;
            for (Node a : temp.neighbors) {
              a.squawks = a.squawks.add(z);
              tot = tot.add(z);
              queue.add(a);
            }
          }
          if (i == t - 1) {
              System.out.println(tot);
              return;
          }
          tot = BigInteger.ZERO;
        }
    }
}
