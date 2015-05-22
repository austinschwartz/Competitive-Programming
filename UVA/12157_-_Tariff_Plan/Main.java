import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 1; i <= T; i++) {
      int N = Integer.parseInt(br.readLine());
      String[] arr = br.readLine().split(" ");
      int milecost = 0;
      int juicecost = 0;
      int callcost;
      for (int j = 0; j < N; j++) {
        callcost = Integer.parseInt(arr[j]) + 1;
        milecost += ((Math.ceil(callcost / 30.0)) * 10);
        juicecost += ((Math.ceil(callcost / 60.0)) * 15);
      }
      System.out.print("Case " + i + ": ");
      if (milecost < juicecost)
        System.out.println("Mile " + milecost);
      else if (milecost > juicecost)
        System.out.println("Juice " + juicecost);
      else
        System.out.println("Mile Juice " + milecost);
    }
  }
}
