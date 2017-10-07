import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int L = 0, L_end = 0;
  public static long[] M, A;
  public static int[] P, M_id;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    List<Long> nums = new ArrayList<Long>();
    while (sc.hasNext())
      nums.add(sc.nextLong());
    int n = nums.size();
    M = new long[n];
    A = new long[n];
    P = new int[n];
    M_id = new int[n];
    Arrays.fill(A, 0);
    for (int i = 0; i < n; i++) {
      A[i] = nums.get(i);
      int pos = Arrays.binarySearch(M, 0, L, A[i]);
      if (pos < 0)
        pos = -pos - 1;
      M[pos] = A[i];
      M_id[pos] = i;
      P[i] = pos > 0 ? M_id[pos - 1] : -1;
      if (pos == L) {
        L++;
        L_end = i;
      }
    }
    out.println(L);
    out.println("-");
    print(L_end);

    out.close();
  }

  public static void print(int end) {
    if (end < 0) return;
    print(P[end]);
    out.println(A[end]);
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
