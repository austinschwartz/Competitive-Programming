import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static List<List<Integer>> findTrackSubsets(int[] tracks, int i) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    if (i == 0) {
      ret.add(new ArrayList<Integer>());
    } else {
      List<List<Integer>> prevSubsets = findTrackSubsets(tracks, i - 1);
      for (List<Integer> prevSubset : prevSubsets) {
        ret.add(prevSubset);
        List<Integer> one = new ArrayList<Integer>();
        one.addAll(prevSubset);
        one.add(tracks[i - 1]);
        ret.add(one);
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.ready()) {
      int sum = sc.nextInt();
      int t = sc.nextInt();
      int[] tracks = new int[t];
      for (int i = 0; i < t; i++) {
        tracks[i] = sc.nextInt();
      }
      List<List<Integer>> trackSubsets = findTrackSubsets(tracks, t);
      int bestTotal = 0;
      for (List<Integer> subset : trackSubsets) {
        int total = 0;
        for (int i : subset)
          total += i;
        if (sum - total >= 0 && sum - total < sum - bestTotal) {
          bestTotal = total;
        }
      }
      List<Integer> longestSubset = null;
      int longestLength = 0;
      for (List<Integer> subset : trackSubsets) {
        int total = 0;
        for (int i : subset)
          total += i;
        if (total != bestTotal)
          continue;
        if (subset.size() > longestLength) {
          longestLength = subset.size();
          longestSubset = subset;
        }
      }
      for (int i = 0; i < longestSubset.size(); i++) {
        System.out.print(longestSubset.get(i) + " ");
      }
      System.out.println("sum:" + bestTotal);
    }
    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean ready() {
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
