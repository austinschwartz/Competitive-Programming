import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] bit;

  public static long sum(int i) {
    long sum = 0;
    while (i > 0) {
      sum += bit[i];
      i -= (i & -i);
    }
    return sum;
  }

  public static void update(int i, int x, int N) {
    while (i <= N) {
      bit[i] += x;
      i += (i & -i);
    }
  }

  public static int inversions(int[] A, int N) {
    int invcount = 0;
    int maxElement = N;
    bit = new int[N + 2];
    for (int i = 1; i < N + 2; i++)
      bit[i] = 0;
    for (int i = N - 1; i >= 0; i--) {
      invcount += sum(A[i] - 1);
      update(A[i], 1, N);
    }

    return invcount;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      String[] originalS = sc.nextLine().split(" ");
      String[] fixedS    = sc.nextLine().split(" ");
      int[] original = new int[N];
      int[] fixed = new int[N];

      Map<String, Integer> map = new HashMap<String, Integer>();
      for (int i = 0; i < N; i++) {
        map.put(fixedS[i], i + 1);
      }

      for (int i = 0; i < N; i++)
       original[i] = map.get(originalS[i]);

      out.println(inversions(original, N));
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
