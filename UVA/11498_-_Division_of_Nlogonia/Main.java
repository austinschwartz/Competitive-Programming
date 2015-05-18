import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != "0") {
      int K = Integer.parseInt(line);
      if (K == 0)
        return;
      line = br.readLine();
      String[] nm = line.split(" ");
      int N = Integer.parseInt(nm[0]);
      int M = Integer.parseInt(nm[1]);
      for (int i = 0; i < K; i++) {
        line = br.readLine();
        String[] xys = line.split(" ");
        int X = Integer.parseInt(xys[0]);
        int Y = Integer.parseInt(xys[1]);
        if (X > N && Y > M)
          System.out.println("NE");
        else if (X > N && Y < M)
          System.out.println("SE");
        else if (X < N && Y > M)
          System.out.println("NO");
        else if (X < N && Y < M)
          System.out.println("SO");
        else
          System.out.println("divisa");
      }
    }
  }
}
