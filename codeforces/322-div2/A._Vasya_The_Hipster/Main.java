import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line[] = br.readLine().split(" ");
    int a = Integer.parseInt(line[0]);
    int b = Integer.parseInt(line[1]);
    int x = Math.min(a, b);
    int y = (Math.max(a, b) - Math.min(a, b)) / 2;
    System.out.println(x + " " + y);
  }
}
