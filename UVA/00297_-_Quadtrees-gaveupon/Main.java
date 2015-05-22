import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String line;
    for (int i = 0; i < N; i++) {
      Main main = new Main();
      QuadTree qt1 = main.QTTools.buildQt(br.readLine());
      QuadTree qt2 = main.QTTools.buildQt(br.readLine());
    }
  }
  public static class QTTools {
    public class QuadTree {
      private Node root;
      private class Node {
        Node NE, SE, SW, NW;
        boolean black;
        Node(boolean black) {
          this.black = black;
        }
      }
    }
    public QuadTree buildQt(String line) {
      return new QuadTree();
    }
  }
}
