import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static Node lastNode = null;
  public static int k;
  public static LinkedHashSet<Node> visited;

  public static class Node {
    public LinkedHashSet<Node> adj;
    public char c;
    public boolean candle;
    public Node(char c) {
      this.c = c;
      adj = new LinkedHashSet<Node>();
      candle = false;
    }
  }

  public static Map<Character, Node> map;

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    String line;
    while (!(line = sc.nextLine()).equals("#")) {
      map = new HashMap<Character, Node>();
      char[] arr = line.toCharArray();
      StringBuilder firstPart = new StringBuilder();
      StringBuilder lastPart = new StringBuilder();
      int period = 0;
      for (char c : arr) {
        if (c == '.' || period == 1) {period++; continue;}
        if (period == 2) {
          lastPart.append(c);
          continue;
        }
        firstPart.append(c);
      }
      String first = firstPart.toString();
      String last = lastPart.toString();

      String[] a = first.split(";");
      String[] b = last.split(" ");
      for (String ai : a) {
        char c = ai.charAt(0);
        Node x;
        if (map.containsKey(c))
          x = map.get(c);
        else
          x = new Node(c);
        map.put(c, x);

        for (int i = 2; i < ai.length(); i++) {
          char d = ai.charAt(i);
          Node y;
          if (map.containsKey(d))
            y = map.get(d);
          else
            y = new Node(d);
          x.adj.add(y);
          map.put(d, y);
        }
      }

      k = Integer.parseInt(b[2]);
      Node theseus = map.get(b[1].charAt(0));
      Node dragon  = map.get(b[0].charAt(0));
      lastNode = dragon;
      // end input shit

      visited = new LinkedHashSet<Node>();
      dfs(theseus, dragon, 1);

      StringBuilder sb = new StringBuilder();
      for (Node node : visited)
        if (node != lastNode)
          sb.append(node.c + " ");

      sb.append("/" + lastNode.c);
      out.println(sb.toString());
    }
    out.close();
  }


  public static boolean dfs(Node prev, Node curr, int step) {
    if (visited.contains(curr)) return false;
    if (prev == curr) return false;
    if (step % k == 0) {
      visited.add(curr);
    }

    Iterator i = curr.adj.iterator();
    if (!i.hasNext()) return false;
    Node next = (Node)i.next();
    while (next == prev || visited.contains(next))
      if (!i.hasNext())
        return false;
      else
        next = (Node)i.next();
    lastNode = next;
    dfs(curr, next, step + 1);

    return true;
  }

  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;
      } catch (IOException e) {
        return false;
      }
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char nextChar() {
      return next().charAt(0);
    }

    public String nextLine() {
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
