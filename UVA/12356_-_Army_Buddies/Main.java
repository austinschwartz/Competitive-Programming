import java.util.*;
import java.io.*;

class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    String line;
    boolean first = true;
    while (!(line = sc.nextLine()).equals("0 0")) {
      if (first == false)
        out.println("-");
      first = false;
      StringTokenizer stk = new StringTokenizer(line);
      int S = Integer.parseInt(stk.nextToken());
      int B = Integer.parseInt(stk.nextToken());
      int[] left = new int[S + 1];
      int[] right = new int[S + 1];
      for (int i = 1; i <= S; i++) {
        left[i] = i - 1;
        right[i] = i + 1;
      }
      for (int i = 0; i < B; i++) {
        stk = new StringTokenizer(sc.nextLine());
        int L = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());
        int newL = -1;
        int newR = -1;
        if (left[L] > 0)
          newL = left[L];
        if (right[R] <= S)
          newR = right[R];
        out.println((newL > 0 ? newL : "*") + " " + (newR > 0 ? newR : "*"));
        if (right[R] <= S)
          left[right[R]] = left[L];
        if (left[L] <= S)
          right[left[L]] = right[R];
      }
    }
    out.println("-");
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
