import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int bs = 0;
    int n = sc.nextInt();
    int m = sc.nextInt();

    ArrayList<Integer>[] hates = (ArrayList<Integer>[])new ArrayList[n];
    for (int i = 0; i < n; i++)
      hates[i] = new ArrayList<Integer>();
    HashMap<String, Integer> map = new HashMap<>();

    String[] names = new String[n];
    for (int i = 0; i < n; i++) {
      names[i] = sc.nextLine();
      map.put(names[i], i);
    }

    for (int i = 0; i < m; i++) {
      String[] sp = sc.nextLine().split(" ");
      int a = map.get(sp[0]);
      int b = map.get(sp[1]);
      hates[a].add(b);
      hates[b].add(a);
    } 
    
    int maxi = 0;
    int max = -1;
    for (int i = 0; i < (1 << n); i++) {
      boolean bad = false;
      int num = 0;
      for (int j = 0; j < n && !bad; j++) {
        if ((i & (1 << j)) != 0) {
          for (int k : hates[j]) {
            if ((i & (1 << k)) != 0) {
              bad = true;
              break;
            }
          }
          num++;
        }
      }
      if (!bad && num > max) {
        maxi = i;
        max = num;
      }
    }

    ArrayList<String> ret = new ArrayList<>();
    for (int i = 0; i < n; i++)
      if ((maxi & (1 << i)) > 0)
        ret.add(names[i]);
    Collections.sort(ret);

    out.println(ret.size());
    for (String s : ret)
      out.println(s);

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
