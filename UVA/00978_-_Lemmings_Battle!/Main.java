import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static class Lemming {
    public int value;
    public char side;
    public Lemming(int value, char side) {
      this.value = value;
      this.side = side;
    }
  }

  public static class Fight {
    public Lemming green;
    public Lemming blue;
    public Fight(Lemming green, Lemming blue) {
      this.green = green;
      this.blue = blue;
    }
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int N = sc.nextInt();
    for (int n = 1; n <= N; n++) {
      if (n != 1)
        out.println();
      int B = sc.nextInt();
      int SG = sc.nextInt();
      int SB = sc.nextInt();
      Fight[] battlefields = new Fight[B];
      TreeMap<Integer, Integer> greens = new TreeMap<>();
      TreeMap<Integer, Integer> blues = new TreeMap<>();
      for (int i = 0; i < SG; i++) {
        int x = sc.nextInt();
        greens.put(x, greens.getOrDefault(x, 0) + 1); 
      }
      for (int i = 0; i < SB; i++) {
        int x = sc.nextInt();
        blues.put(x, blues.getOrDefault(x, 0) + 1); 
      }

      while (greens.size() > 0 && blues.size() > 0) {

        // Assigning
        for (int i = 0; i < B; i++) {
          if (greens.size() == 0 || blues.size() == 0)
            break;
          int gValue = greens.lastKey();
          int gCount = greens.get(gValue);
          Lemming green = new Lemming(gValue, 'g');
          if (gCount > 1)
            greens.put(gValue, gCount - 1);
          else
            greens.remove(gValue);

          int bValue = blues.lastKey();
          int bCount = blues.get(bValue);
          Lemming blue = new Lemming(bValue, 'b');
          if (bCount > 1)
            blues.put(bValue, bCount - 1);
          else
            blues.remove(bValue);

          battlefields[i] = new Fight(green, blue);
        }

        // Fighting
        for (int i = 0; i < B; i++) {
          Fight fight = battlefields[i];
          if (fight == null)
            continue;
          Lemming green = fight.green;
          Lemming blue = fight.blue;
          if (green.value == blue.value) {
            // Nothing
          } else if (green.value > blue.value) {
            int x = green.value - blue.value;
            greens.put(x, greens.getOrDefault(x, 0) + 1); 
          } else {
            int x = blue.value - green.value;
            blues.put(x, blues.getOrDefault(x, 0) + 1); 
          }
          battlefields[i] = null;
        }
      }

      if (blues.size() == 0 && greens.size() == 0) {
        out.println("green and blue died");
      } else if (greens.size() > 0) {
        out.println("green wins");
        for (Map.Entry<Integer, Integer> entry : greens.descendingMap().entrySet())
          for (int i = 0; i < entry.getValue(); i++)
            out.println(entry.getKey());
      } else {
        out.println("blue wins");
        for (Map.Entry<Integer, Integer> entry : blues.descendingMap().entrySet())
          for (int i = 0; i < entry.getValue(); i++)
            out.println(entry.getKey());
      };
    }
    out.close();
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
