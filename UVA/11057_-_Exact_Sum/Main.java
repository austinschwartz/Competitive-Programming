import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int a, b;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int i = 1;
    while (sc.hasNext()) {
      int N = 0;
      try {
        N = sc.nextInt();
      } catch (Exception e) {break;}
      int[] nums = new int[N];
      for (int n = 0; n < N; n++) {
        nums[n] = sc.nextInt();
      }
      int t = sc.nextInt();
      solve(nums, N, t);
      if (i != 1)
        out.println("");
      out.println(String.format("Peter should buy books whose prices are %d and %d.", a, b));
      i += 1;
      sc.nextLine();
    }
    out.println("");
    out.close();
  }

  public static void solve(int[] nums, int n, int t) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<int[]> answers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(t - nums[i]))
        answers.add(new int[]{t - nums[i], nums[i]});
      else
        map.put(nums[i], i);
    }
    int[] ret = answers.get(0);
    Arrays.sort(ret);
    for (int i = 1; i < answers.size(); i++) {
      int[] arr = answers.get(i);
      Arrays.sort(arr);
      if (arr[1] - arr[0] < ret[1] - ret[0])
        ret = arr;
    }
    a = ret[0];
    b = ret[1];
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
