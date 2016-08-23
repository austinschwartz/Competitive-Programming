import java.io.*;
import java.util.*;

public class Main {
  public static int memof[];
  public static int memog[];

  public static int f(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (n == 1) return 0;
    if (memof[n] != -1) return memof[n];
    return memof[n] = f(n - 2) + 2 * g(n - 1);
  }

  public static int g(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (memog[n] != -1) return memog[n];
    return memog[n] = f(n - 1) + g(n - 2);
  }

  public static void main(String[] args) throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;
    memof = new int[31];
    memog = new int[31];
    Arrays.fill(memof, -1);
    Arrays.fill(memog, -1);
    while ((n = Integer.parseInt(br.readLine())) != -1) {
      System.out.println(f(n));
    }
  }
}
