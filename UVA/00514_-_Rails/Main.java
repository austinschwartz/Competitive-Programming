import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n;
    boolean flag = false;
    while ((n = sc.nextInt()) != 0) {
      if (flag) 
        out.println("");
      flag = true;
      String line;
      while (((line = sc.nextLine()) != null) && !line.equals("0")) {
        int[] arr = new int[n];
        String[] split = line.split(" ");
        for (int i = 0; i < n; i++)
          arr[i] = Integer.parseInt(split[i]);

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
          int c = arr[i];
          while (j < n && j != c) {
            if (stack.size() > 0 && stack.peek() == c)
              break;
            j++;
            stack.push(j);
          }
          if (stack.peek() == c)
            stack.pop();

        }

        out.println(stack.size() == 0 ? "Yes" : "No");
      }
    }
    out.println();
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
