import java.util.*;
import java.io.*;

class Main {
  public static int[][] memo;
  public static int M, C;
  public static int[][] price;
  
  public static int shop(int money, int g) {
    if (money < 0) return -999999;
    if (g == C) return M - money;
    if (memo[money][g] != -1) return memo[money][g];
    int ans = -1;
    for (int model = 1; model <= price[g][0]; model++) {
      ans = Math.max(ans, shop(money - price[g][model], g + 1));
    }
    memo[money][g] = ans;
    return memo[money][g];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int k = 0; k < N; k++) {
      price = new int[25][25];
      memo = new int[210][25];
      String[] line = br.readLine().split(" ");
      M = Integer.parseInt(line[0]); // money
      C = Integer.parseInt(line[1]); // # of garments
      for (int i = 0; i < C; i++) {
        String[] garmentList = br.readLine().split(" ");
        int K = Integer.parseInt(garmentList[0]);
        price[i][0] = K;
        for (int j = 1; j <= K; j++) {
          price[i][j] = Integer.parseInt(garmentList[j]);
        }
      }
      for (int i = 0; i < 210; i++)
        Arrays.fill(memo[i], -1);
      int score = shop(M, 0);
      if (score < 0)
        System.out.println("no solution");
      else
        System.out.println(score);
    }
  }
}
