import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] par;
  public static int[] size;
  public static int find(int a) {
    if (par[a] == a)
      return par[a];
    par[a] = find(par[a]);
    return par[a];
  }

  public static void union(int i, int j) {
    int p = find(i);
    int q = find(j);
    if (size[q] > size[p]) {
      int temp = p;
      p = q;
      q = temp;
    }
    if (p == q)
      return;
    size[p] += size[q];
    size[q] = 0;
    par[q] = par[p];
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int m = sc.nextInt();
      int n = 0;
      size = new int[200000];
      par = new int[200000];
      for (int i = 0; i < 200000; i++) {
        par[i] = i;
        size[i] = 1;
      }
      HashMap<String, Integer> map = new HashMap<>();
      for (int i = 0; i < m; i++) {
        String[] sp = sc.nextLine().split(" ");
        String a = sp[0];
        String b = sp[1];
      
        if (!map.containsKey(a)) {
          map.put(a, n);
          n += 1;
        }
        if (!map.containsKey(b)) {
          map.put(b, n);
          n += 1;
        }
        int p = map.get(a);
        int q = map.get(b);
        union(p, q);
        out.println(size[find(par[q])]);
      }
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
