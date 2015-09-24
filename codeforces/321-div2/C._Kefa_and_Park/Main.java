import java.util.*;
import java.io.*;

public class Main {
  public static Map<Node, Integer> map = new HashMap<Node, Integer>();
  public static int o;
  public static class Node {
    public ArrayList<Node> children;
    public int val;
    public boolean hasCat;
    public int catCount;
    public Node(int val) {
      this.val = val;
      this.hasCat = false;
      this.children = new ArrayList<Node>();
    }
  }

  public static void printTree(Node root) {
    LinkedList<Node> ll = new LinkedList<Node>();
    ll.add(root);
    while (!ll.isEmpty()) {
      Node temp = ll.remove();
      System.out.println(temp.val + " : " + (temp.hasCat ? "cat" : "no"));
      for (Node node : temp.children) {
        ll.add(node);
      }
    }
    return;
  }

  public static void numRestaraunts(Node node, int maxCats, int k) {
    if (k > maxCats) return;
    int ok = 1;
    for (Node child : node.children) {
      
    }
    o += ok;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int[] cats = new int[n];
    Node[] nodes = new Node[n];
    nodes[0] = new Node(1);
    StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      cats[i] = Integer.parseInt((String)tk.nextElement());
    }
    if (cats[0] == 1) {
      nodes[0].hasCat = true;
      map.put(nodes[0], 1);
    }
    for (int i = 1; i < n; i++) {
      line = br.readLine().split(" ");
      int x = Integer.parseInt(line[0]);
      int y = Integer.parseInt(line[1]);
      Node node = new Node(y);
      if (cats[i] == 1) {
        node.hasCat = true;
        map.put(node, 1);
      } else {
        map.put(node, 0);
      }
      nodes[i] = node;
      nodes[x - 1].children.add(node);
    }
    numRestaraunts(nodes[0], m, mp.get(nodes[0]));
    System.out.println(o);
  }
}
