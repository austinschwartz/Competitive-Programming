import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void printImage(boolean[][] grid, int H, int W) {
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < 4 * W; j++) {
        System.out.print(grid[i][j] ? "1" : "0");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int H, W;
    while ((H = sc.nextInt()) != 0 &&
           (W = sc.nextInt()) != 0) {
      boolean[][] grid = new boolean[H][W*4];
      for (int i = 0; i < H; i++) {
        char[] row = sc.nextLine().toCharArray();
        int colIndex = 0;
        for (int j = 0; j < (W/2); j++) {
          String hex = row[2 * j] + "" + row[(2 * j) + 1];
          int num = Integer.parseInt(hex, 16);
          String binary = Integer.toBinaryString(num);
          String binaryPadded = "00000000".substring(binary.length()) + binary;
          for (int k = 0; k < 8; k++) {
            grid[i][colIndex] = (binaryPadded.charAt(k) != '0');
            colIndex++;
          }
        }
      }
      printImage(grid, H, W);
    }
    out.close();
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
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
