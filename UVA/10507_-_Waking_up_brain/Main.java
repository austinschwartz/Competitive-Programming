import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static ArrayList<Integer>[] adjList;
  public static int[] par;
  public static HashSet<Integer> wokeSet;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      wokeSet = new HashSet<>();
      adjList = (ArrayList<Integer>[])new ArrayList[26];
      for (int i = 0; i < 26; i++)
        adjList[i] = new ArrayList<Integer>();
      par = new int[26];
      for (int i = 0; i < 26; i++)
        par[i] = i;
      int N = sc.nextInt(); // slept
      int M = sc.nextInt(); // edges
      char[] woke = sc.nextLine().toCharArray();
      int a = woke[0] - 'A';
      int b = woke[1] - 'A';
      int c = woke[2] - 'A';
      wokeSet.add(a);
      wokeSet.add(b);
      wokeSet.add(c);
      union(b, a);
      union(c, a);
      for (int i = 0; i < M; i++) {
        char[] ch = sc.nextLine().toCharArray();
        int u = ch[0] - 'A';
        int v = ch[1] - 'A';
        adjList[u].add(v);
        adjList[v].add(u);
      }

      int years = 0;
      if (wokeSet.size() < N) {
        int prev = -1;
        int curr = 0;
        while (prev != curr && wokeSet.size() < N) {
          prev = curr;
          HashSet<Integer> update = new HashSet<>();
          for (int i = 0; i < 26; i++) {
            if (wokeSet.contains(i))
              continue;
            if (hasThreeWokeNeighbors(i)) {
              update.add(i);
              curr += 1;
            }
          }
          for (int i : update) {
            //out.println("woking " + (char)(i + 'A') + " " + years) ;
            union(i, a);
            adjList[a].add(i);
            adjList[i].add(a);
            wokeSet.add(i);
          }

          years += 1;
        }
      }
      if (wokeSet.size() >= N)
        out.println(String.format("WAKE UP IN, %d, YEARS", years));
      else
        out.println("THIS BRAIN NEVER WAKES UP");
      sc.nextLine();
    }
    out.close();
  }

  public static boolean hasThreeWokeNeighbors(int i) {
    int count = 0;
    for (int j : adjList[i]) {
      if (wokeSet.contains(j))
        count += 1;
      //out.println((char)(i + 'A') + " has " + count + " woke neighbors");
    }
    return count >= 3;
  }

  public static int compSize(int a) {
    int ret = 0;
    int p = find(a);
    for (int i = 0; i < 26; i++)
      if (par[i] == p)
        ret += 1;
    return ret;
  }

  public static int find(int a) {
    if (a == par[a])
      return a;
    par[a] = find(par[a]);
    return par[a];
  }

  public static void union(int a, int b) {
    par[find(a)] = par[find(b)];
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
