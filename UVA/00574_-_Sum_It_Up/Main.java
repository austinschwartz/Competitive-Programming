import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t;
    int n;
    while ((t = sc.nextInt()) != Integer.MAX_VALUE && (n = sc.nextInt()) != 0) {
      used = new HashSet<List<Integer>>();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      System.out.println("Sums of " + t + ":");
      List<List<Integer>> ret = recur(nums, n, t, n);
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      int count = 0;
      for (List<Integer> list : ret) {
        if (sum(list) == t) {
          count++;
          if (used.contains(list))
            continue;
          used.add(list);
          res.add(list);
        }
      }
      if (count == 0)
        System.out.println("NONE");
      else {
        Collections.sort(res, new Comparator<List<Integer>>() {
          @Override
          public int compare(List<Integer> a, List<Integer> b) {
            if (b.get(0) == a.get(0)) {
              if (b.get(1) == a.get(1)) {
                if (b.get(2) == a.get(2)) {
                  if (b.get(3) == a.get(3)) {
                    if (b.get(4) == a.get(4)) {
                      if (b.get(5) == a.get(5)) {
                        if (b.get(6) == a.get(6)) {
                          return b.get(7).compareTo(a.get(7));
                        }
                        return b.get(6).compareTo(a.get(6));
                      }
                      return b.get(5).compareTo(a.get(5));
                    }
                    return b.get(4).compareTo(a.get(4));
                  }
                  return b.get(3).compareTo(a.get(3));
                }
                return b.get(2).compareTo(a.get(2));
              }
              return b.get(1).compareTo(a.get(1));
            }
            return b.get(0).compareTo(a.get(0));
          }
        });
        for (List<Integer> list : res) {
          c(list);
        }
      }
    }
    out.close();
  }

  public static void c(List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (i < list.size() - 1)
        System.out.print(list.get(i) + "+");
      else
        System.out.println(list.get(i));
    }
  } 

  public static Set<List<Integer>> used;

  public static int sum(List<Integer> lst) {
    int x = 0;
    for (int i : lst)
      x += i;
    return x;
  }

  public static List<List<Integer>> recur(int[] nums, int n, int t, int i) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    if (i == 0) {
      ret.add(new ArrayList<Integer>());
    } else {
      List<List<Integer>> prev = recur(nums, n, t - nums[i - 1], i - 1);
      for (List<Integer> lst : prev) {
        List<Integer> newList = new ArrayList<Integer>();
        newList.addAll(lst);
        newList.add(nums[i - 1]);
        ret.add(newList);
      }
      ret.addAll(prev);
    }
    return ret;
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
