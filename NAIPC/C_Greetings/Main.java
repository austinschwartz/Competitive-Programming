import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int[] W, H, Q;
  public static int n;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    n = sc.nextInt();
    int k = sc.nextInt();
    W = new int[n];
    H = new int[n];
    Q = new int[n];
    for (int i = 0; i < n; i++) {
      W[i] = sc.nextInt();
      H[i] = sc.nextInt();
      Q[i] = sc.nextInt();
    }
    out.println(f(k));
    out.close();
  }

  public static class Envelope {
    public int i, w, h, q, area;
    public boolean used;
    public Envelope(int i, int w, int h, int q) {
      this.i = i;
      this.w = w;
      this.h = h;
      this.q = q;
      this.area = w * h;
      this.used = false;
    }
  }

  public static Envelope[] envs;

  public static int f(int k) {
    if (k >= n)
      return 0;
    if (k == 1)
      return fk((1 << n) - 1); // 1s of size n

    envs = new Envelope[n];
    for (int i = 0; i < n; i++) {
      envs[i] = new Envelope(i, W[i], H[i], Q[i]);
    }

    // min waste -> max waste
    Arrays.sort(envs, new Comparator<Envelope>(){
      @Override
      public int compare(Envelope a, Envelope b) {
        return (a.area * a.q) - (b.area * b.q);
      }
    });

    //for (int i = 0; i < n; i++) {
      //out.println(envs[i].i + " " + envs[i].area * envs[i].q);
    //}

    int w = 0;
    int bitset = ((1 << n) - 1);
    int indx = n - 1;
    while (bitset > 0) {
      int area = envs[indx].area;
      int curset = 0;
      for (int i = 0; i < n; i++) {
        if (envs[i].area <= area && !envs[i].used) {
          curset |= (1 << envs[i].i);
          envs[i].used = true;
        }
      }
      if (curset == 0)
        indx--;
      w += fk(curset);
      bitset &= ~curset;
    }

    return w;
  }

  public static int max_width = Integer.MIN_VALUE;
  public static int max_height = Integer.MIN_VALUE;

  public static int fk(int bitset) {
    if (bitset == 0)
      return 0;
    int old_bitset = bitset;
    max_width = Integer.MIN_VALUE;
    max_height = Integer.MIN_VALUE;
    int total_waste = 0;
    int i = 0;
    while (bitset > 0) { 
      if ((bitset & 1) == 1) {
        max_width = Math.max(W[i], max_width);
        max_height = Math.max(H[i], max_height);
      }
      i++;
      bitset /= 2;
    }

    bitset = old_bitset;
    i = 0;
    while (bitset > 0) {
      if ((bitset & 1) == 1) {
        if (envs[i].used) continue;
        total_waste += (Q[i] * waste(W[i], H[i], max_width, max_height));
      }
      i++;
      bitset /= 2;
    }

    return total_waste;
  }

  public static int waste(int w, int h, int w2, int h2) {
    int wmax = Math.max(w, w2);
    int wmin = Math.min(w, w2);
    int hmax = Math.max(h, h2);
    int hmin = Math.min(h, h2);
    return (wmax * hmax) - (wmin * hmin);
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
