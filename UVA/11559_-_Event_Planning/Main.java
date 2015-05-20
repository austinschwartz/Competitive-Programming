import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      int N = Integer.parseInt(arr[0]);
      int B = Integer.parseInt(arr[1]);
      int H = Integer.parseInt(arr[2]);
      int W = Integer.parseInt(arr[3]);
      int mincost = Integer.MAX_VALUE;
      for (int i = 0; i < H; i++) {
        int hasbeds = 0;
        int p = Integer.parseInt(br.readLine());
        String[] beds = br.readLine().split(" ");
        for (int j = 0; j < W; j++) {
          int bedcount = Integer.parseInt(beds[j]);
          int cost = 0;
          if (bedcount >= N) {
            cost = (p * N);
            if (cost < mincost)
              mincost = cost;
          }
        }

      }
      if (mincost < Integer.MAX_VALUE && mincost < B)
        System.out.println(mincost);
      else
        System.out.println("stay home");
    }
  }
}
