import java.util.*;
public class Main {
  public static int[] dp;
  public static int solve(int size) {
    if (size < 0)
      return (int)(-1e8);
    if (dp[size] >= 0)
      return dp[size];

    int m = (int)(-1e8);
    if (n >= a) m = Math.max(m, 1 + solve(size - a));
    if (n >= b) m = Math.max(m, 1 + solve(size - b));
    if (n >= c) m = Math.max(m, 1 + solve(size - c));

    dp[size] = m;
    return m;
  }

  public static int n, a, b, c;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = scan.nextInt();
    b = scan.nextInt();
    c = scan.nextInt();
    dp = new int[n + 1];
    Arrays.fill(dp, (int)(-1e8));
    dp[0] = 0;
    
    for (int i = 1; i <= n; i++) {
      if (i >= a) dp[i] = Math.max(dp[i], dp[i-a] + 1);
      if (i >= b) dp[i] = Math.max(dp[i], dp[i-b] + 1);
      if (i >= c) dp[i] = Math.max(dp[i], dp[i-c] + 1);
    }
   
    System.out.println(dp[n]);
  }
}

