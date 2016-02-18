import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int n = sc.nextInt();
      List<int[]> ones = new ArrayList<int[]>();
      List<int[]> threes = new ArrayList<int[]>();
      for (int i = 0; i < n; i++) {
        char[] line = sc.nextLine().toCharArray();
        for (int j = 0; j < n; j++) {
          if (line[j] == '1')
            ones.add(new int[]{i, j});
          else if (line[j] == '3')
            threes.add(new int[]{i, j});
        }
      }
      int max = Integer.MIN_VALUE;
      for (int[] one : ones) {
        int min = Integer.MAX_VALUE;
        for (int[] three : threes) {
          int dist = Math.abs(one[0] - three[0]) + Math.abs(one[1] - three[1]);
          min = Math.min(dist, min);
        }
        max = Math.max(max, min);
      }
      out.println(max);
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
