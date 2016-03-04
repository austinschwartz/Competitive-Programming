import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static boolean[][] matrix;
  public static int n, m;
  
  public static int MAX_BOLTS = 1001;
  public static int MAX_NUTS  = 1001;

  private static ArrayList<ArrayList<Integer>> AdjList = 
    new ArrayList<ArrayList<Integer>>();
  private static ArrayList<Integer> match;
  private static Set<Integer> visitedset;

  private static int Aug(int l) {
    if (visitedset.contains(l)) return 0;
    visitedset.add(l);
    for (int right : AdjList.get(l)) {
      if (match.get(right) == -1 || Aug(match.get(right)) == 1) {
        match.set(right, l);
        return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      n = sc.nextInt(); 
      m = sc.nextInt();
  
      int V = n, V_l = m;
      AdjList.clear();
      for (int i = 0; i < MAX_NUTS; i++)
        AdjList.add(new ArrayList<Integer>());

      for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
          if (sc.nextInt() == 1)
            AdjList.get(i).add(j);


      int MCBM = 0;
      match = new ArrayList<Integer>();
      match.addAll(Collections.nCopies(MAX_NUTS, -1));
      for (int l = 0; l < MAX_NUTS; l++) {
        visitedset = new HashSet<Integer>();
        MCBM += Aug(l);
      }

      out.printf("Case %d: a maximum of %d nuts and bolts can be fitted together\n", t, MCBM);

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
