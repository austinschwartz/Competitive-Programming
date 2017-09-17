import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int size = (int)Math.pow(2, n);
      int[] ws = new int[size];
      int[] sums = new int[size];
      for (int i = 0; i < size; i++) {
        ws[i] = sc.nextInt();
      }
      for (int i = 0; i < size; i++) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
          int newCur = i ^ (1 << j);
          sum += ws[newCur];
        }
        sums[i] = sum;
      }
      int maxSum = -1;
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < n; j++) {
          int cur = i ^ (1 << j);
          if (cur != i) {
            maxSum = Math.max(sums[cur] + sums[i], maxSum);
          }
        }
      }
      out.println(maxSum);
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
