import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      boolean works = true;
      int threads = sc.nextInt();
      int stack_size = 0;
      Stack<Integer>[] stacks = new Stack[threads];
      for (int i = 0; i < threads; i++) {
        stacks[i] = new Stack<Integer>();
        int count = sc.nextInt();
        for (int j = 0; j < count; j++) {
          stacks[i].push(sc.nextInt());
          stack_size++;
        }
      }

      for (int i = 0; i < stack_size; i++) {
        int x = sc.nextInt();
        boolean found = false;
        for (int j = 0; j < threads; j++) {
          if (stacks[j].isEmpty()) continue;
          if (stacks[j].peek() == x) {
            stacks[j].pop(); 
            found = true;
          }
        }
        if (!found) works = false;
      }

      for (int i = 0; i < threads; i++)
        if (stacks[i].size() != 0)
          works = false;



      out.println(works ? "Yes" : "No");
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
