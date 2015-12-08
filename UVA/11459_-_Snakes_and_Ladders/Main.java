import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int[] grid = new int[100];
      int a = sc.nextInt();
      int[] pos = new int[a];
      Arrays.fill(pos, 1);
      int b = sc.nextInt();
      int c = sc.nextInt();
      Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();
      for (int j = 0; j < b; j++) {
        int first = sc.nextInt();
        int second = sc.nextInt();
        ladders.put(first, second);
      }
      boolean won = false;
      for (int j = 0; j < c; j++) {
        int roll = sc.nextInt();
        if (won) continue;
        pos[j % a] += roll;
        if (pos[j % a] >= 100) {
          pos[j % a] = 100;
          won = true;
          continue;
        }
        if (ladders.containsKey(pos[j % a])) {
          pos[j % a] = ladders.get(pos[j % a]);
          if (pos[j % a] >= 100) {
            pos[j % a] = 100;
            won = true;
            continue;
          }
        }
      }
      for (int j = 0; j < a; j++) {
        out.println("Position of player " + (j + 1) + " is " + pos[j] + ".");
      }
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
