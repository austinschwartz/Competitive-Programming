import java.util.*;
import java.io.*;

public class Main {
  public static Map<Node, Integer> map = new HashMap<Node, Integer>();
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

  public static int numRestaraunts(Node node, int maxCats, Node[] nodes) {
    if (maxCats == 0) return 0;
    if (node == null) return 0;
    Stack<Node> stack = new Stack<Node>();
    stack.push(node);

    while (!stack.isEmpty()) {
      Node prev = stack.pop();
      //System.out.println(prev.val + " " + map.get(prev));
      for (Node child : prev.children) {
        stack.add(child);
        int prevCats = map.get(prev);
        if (prevCats > maxCats)
          map.put(child, prevCats);
        else if ((prevCats > 0 && child.hasCat))
          map.put(child, map.get(prev) + 1);
      }
    }
    Node t;
    int total = 0;
    for (int i = 0; i < nodes.length; i++) {
      t = nodes[i];
      if (t.children.size() == 0 && map.get(t) <= maxCats) {
        //System.out.println("leafs: " + t.val);
        total++;
      }

    }
    return total;
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
    System.out.println(numRestaraunts(nodes[0], m, nodes));
  }
}
