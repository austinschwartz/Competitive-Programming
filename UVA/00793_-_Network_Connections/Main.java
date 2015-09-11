import java.util.*;
import java.io.*;

public class Main {
  public static class UnionFind {
    public int[] p;
    public int[] rank;
    public UnionFind(int N) {
      p = new int[N + 1];
      rank = new int[N + 1];
      for (int i = 0; i < N + 1; i++) {
        p[i] = i;
      }
    }
    public int findSet(int i) {
      return (p[i] == i ? i : (p[i] = findSet(p[i])));
    }
    public boolean isSameSet(int i, int j) {
      return findSet(i) == findSet(j);
    }
    public void unionSet(int i, int j) {
      if (!isSameSet(i, j)) {
        int x = findSet(i);
        int y = findSet(j);
        if (rank[x] > rank[y])
          p[y] = x;
        else {
          p[x] = y;
          if (rank[x] == rank[y])
            rank[y]++;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    br.readLine();
    for (int i = 0; i < T; i++) {
      if (i > 0 && i < T)
        System.out.println();
      int n = Integer.parseInt(br.readLine());
      UnionFind uf = new UnionFind(n);
      String line;
      int success = 0;
      int unsuccess = 0;
      while (true) {
        line = br.readLine();
        if (line == null || line.equals(""))
          break;
        String[] a = line.split(" ");
        String x = a[0];
        int y = Integer.parseInt(a[1]);
        int z = Integer.parseInt(a[2]);
        if (x.equals("c"))
          uf.unionSet(y, z);
        else {
          if (uf.isSameSet(y, z))
            success++;
          else
            unsuccess++;
        }
      }
      System.out.println(success + "," + unsuccess);
    }
  }
}
