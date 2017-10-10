import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    List<int[]> nums = new ArrayList<>();
    int index = 0;
    while (sc.hasNext()) {
      int w = sc.nextInt();
      int s = sc.nextInt();
      nums.add(new int[]{w, s, index++});
    }
    Collections.sort(nums, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        if (a[0] != b[0])
          return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
      }
    });

    int n = nums.size();
    int[] dp = new int[n];
    int[] par = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; i++)
      par[i] = i;
    for (int i = 0; i < n; i++) {
      int[] a = nums.get(i);
      for (int j = i - 1; j >= 0; j--) {
        int[] b = nums.get(j);
        if (a[0] != b[0] && a[1] < b[1]) {
          if (dp[i] <= dp[j] + 1) {
            dp[i] = dp[j] + 1;
            par[i] = j;
          }
        }
      }
    }

    int max = 0;
    int pointer = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i] > max) {
        max = dp[i];
        pointer = i;
      }
    }

    List<Integer> ret = new ArrayList<Integer>();
    while (par[pointer] != pointer) {
      ret.add(nums.get(pointer)[2] + 1);
      pointer = par[pointer];
    }

    ret.add(nums.get(pointer)[2] + 1);
    out.println(ret.size());
    for (int i = ret.size() - 1; i >= 0; i--) {
      out.println(ret.get(i));
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
