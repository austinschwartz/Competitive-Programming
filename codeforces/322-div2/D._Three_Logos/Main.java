import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int x1 = Integer.parseInt(line[0]);
    int y1 = Integer.parseInt(line[1]);
    int x2 = Integer.parseInt(line[2]);
    int y2 = Integer.parseInt(line[3]);
    int x3 = Integer.parseInt(line[4]);
    int y3 = Integer.parseInt(line[5]);
    int x = x1 * y1 + x2 * y2 + x3 * y3;
    if (Math.sqrt(x) * Math.sqrt(x) != x)
      System.out.println("-1");
    else
    {

    }
      
  }
}
