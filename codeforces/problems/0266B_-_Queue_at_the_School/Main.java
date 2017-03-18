import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    int t = sc.nextInt();
    boolean[] nums = new boolean[n];
    char[] line = sc.nextLine().toCharArray();
    char[] newline = new char[n];
    Arrays.fill(newline, 'x');
    for (int i = 0; i < t; i++) {
      for (int j = 0; j <  n - 1; j++) {
        newline[j] = line[j];
        if (line[j] == 'B' && line[j+1] == 'G') {
          newline[j] = line[j+1];
          newline[j + 1] = line[j];
          j++;
        }
      }
      if (newline[n - 1] == 'x')
        newline[n - 1] = line[n - 1];
      for (int j = 0; j < n; j++)
        line[j] = newline[j];
    }
    out.println(new String(newline));
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
