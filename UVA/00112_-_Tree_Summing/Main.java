import java.io.*;
import java.util.*;

class Node {
  public Node left, right;
  public int val;
  public Node(int val) {
    this.val = val;
  }
}

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      String line = sc.nextLine().replaceAll("\\s+", "");
      if (line.equals("")) break;
      while (stack(line) != 0)
        line = line + sc.nextLine().replaceAll("\\s+", "");
      int index = 0;
      for (; index < line.length(); index++) {
        if ((line.charAt(index) > '9' || line.charAt(index) < '0') && line.charAt(index) != '-')
          break;
      }
      int n = Integer.parseInt(line.substring(0, index));
      String rest = line.substring(index);
      
      rest = rest
        .replaceAll("(\\(\\s*\\))", " \\# ")
        .replaceAll("[\\(\\)]", " ")
        .replaceAll("    ", " ")
        .replaceAll("   ", " ")
        .replaceAll("\\s+", " ");
      Node tree = sc.deserialize(rest); 
      out.println(rootSum(n, tree) ? "yes" : "no");
    }
    out.close();
  }

  public static int stack(String str) {
    int stack = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') stack++;
      if (str.charAt(i) == ')') stack--;
    }
    return stack;
  }

  public static boolean rootSum(int n, Node tree) {
    if (n == 0 && tree == null)
      return false;
    else if (tree == null)
      return false;

    if (tree.left == null && tree.right == null && n - tree.val == 0)
      return true;

    boolean ret = false;
    if (tree.left != null)
      ret |= rootSum(n - tree.val, tree.left);
    if (tree.right != null)
      ret |= rootSum(n - tree.val, tree.right);
    return ret;
  }

  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public Node deserialize(String s){
      if (s == null || s.length() == 0) return null;
      StringTokenizer st = new StringTokenizer(s, " ");
      return deserialize(st);
    }

    private Node deserialize(StringTokenizer st){
      if (!st.hasMoreTokens())
        return null;
      String val = st.nextToken();
      if (val.equals("#"))
        return null;
      Node root = new Node(Integer.parseInt(val));
      root.left = deserialize(st);
      root.right = deserialize(st);
      return root;
    }

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
      try {
      return Integer.parseInt(next());
      } catch (Exception e) { return -1; }
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
