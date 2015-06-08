#include <cstdio>
#include <algorithm>

using namespace std;

int max(int a, int a2) {return a >= a2 ? a : a2;}

int main() {
  int b, n;
  for (;;) {
    scanf("%d %d\n", &b, &n);
    if (b == 0 && n == 0)
      break;
    int fun[n+1];
    int cost[n+1];
    for (int i = 0; i < n; i++) {
      scanf("%d %d\n", &cost[i], &fun[i]);
    }
    int dp[n+1][b+1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = 0;
    for (int j = 0; j <= b; j++)
      dp[0][j] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= b; j++) {
        if (cost[i-1] <= j)
          dp[i][j] = max(dp[i-1][j], dp[i-1][j-cost[i-1]] + fun[i-1]);
        else
          dp[i][j] = dp[i-1][j];
      }
    }
    int mincost = dp[n][b];
    int i;
    for (i = b; i; i--)
      if (dp[n][i] < mincost)
        break;
    printf("%d %d\n", i+1, dp[n][b]);
  }

}
